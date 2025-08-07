package com.barclays.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.offers.builder.OffersRequestBuilder;
import com.barclays.offers.builder.OffersResponseBuilder;
import com.barclays.offers.dao.IOffersDao;
import com.barclays.offers.ennrollment.svcclient.IEnrollmentServiceClient;
import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.CardVerifyRequest;
import com.barclays.offers.model.CardVerifyResponse;
import com.barclays.offers.model.EnrollmentRequest;
import com.barclays.offers.model.EnrollmentResponse;
import com.barclays.offers.model.OffersDaoRequest;
import com.barclays.offers.model.OffersDaoResponse;
import com.barclays.offers.model.OffersRequest;
import com.barclays.offers.model.OffersResponse;
import com.barclays.offers.verify.svcClient.ICardVerifyServiceClient;

@Component
public class OfferServiceimpl implements IOffersService{
	
	@Autowired
	IEnrollmentServiceClient enrollmentServiceClient;
	
	@Autowired
	ICardVerifyServiceClient cardVerifySvcClient;
	
	@Autowired
	IOffersDao offersDao;
	
	@Autowired
	OffersRequestBuilder requestBuilder;
	
	@Autowired
	OffersResponseBuilder responseBuilder;    

	@Override
	public OffersResponse getOffers(OffersRequest offersRequest) throws BusinessException,SystemException {
		
		//1.Get the request from controller layer
		
		
		//2.prepare the request for enrollmentServiceClient i.e convert offersRequest to EnrollmentServiceRequest 
		
		EnrollmentRequest enrollmentRequest = requestBuilder.buildEnrollmentRequest(offersRequest);
		
		//3.call enrollmentServiceClient and get the response
		
		EnrollmentResponse enrollmentResp = enrollmentServiceClient.enrollment(enrollmentRequest);
		
		//apply business logic on enrollmentResp
		
		//4.prepare the request for cardVerifySvcClient i.e convert offersRequest to CardVerifyRequest
		
		CardVerifyRequest cardVerifyReq = requestBuilder.buildCardVerifyReq(offersRequest);
		
		//5.call cardVerifySvcClient and get the response
		
		CardVerifyResponse cardVerifyResp = cardVerifySvcClient.verifyCard(cardVerifyReq);
		
		//6.prepare the request for dao object. convert offersRequest to daoRequest
		
		OffersDaoRequest daoReq = requestBuilder.buildDaoRequest(offersRequest);
		
		//7.call dao and get the response
		
		OffersDaoResponse daoResp = offersDao.getOffers(daoReq);
		
		//apply business logic in dao response
		
		//8.prepare the offersresponse
		
		OffersResponse offerResp = responseBuilder.buildOffersResp(enrollmentResp,cardVerifyResp,daoResp);
		
		
		
		return offerResp;
	}
	

}
