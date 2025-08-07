package com.barclays.card.verify.builder;

import org.springframework.stereotype.Component;

import com.barclays.card.verify.model.CardVerifyRequest;
import com.barclays.card.verify.model.EnrollmentRequest;
import com.barclays.card.verify.model.OffersDaoRequest;
import com.barclays.card.verify.model.OffersRequest;

@Component
public class OffersRequestBuilder {
	
	/**
	 * 
	 * @param offersRequest
	 * @return EnrollmentRequest
	 */
	
	public EnrollmentRequest buildEnrollmentRequest(OffersRequest offersRequest)
	{
		
		//TODO : Prepare the EnrollmentRequest with the help of offerRequest
		
		EnrollmentRequest enrollmentReq = new EnrollmentRequest();
		enrollmentReq.setCardnum(offersRequest.getCardNum());
		offersRequest.setCorrelational(offersRequest.getCorrelational());
		 
		return enrollmentReq;
	}
	
	/**
	 * Description : prepare the cardVerify request object with the help of offersRequest object
	 * @param offersRequest
	 * @return
	 */

	public CardVerifyRequest buildCardVerifyReq(OffersRequest offersRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public OffersDaoRequest buildDaoRequest(OffersRequest offersRequest) {

		OffersDaoRequest offerDaoRequest = new OffersDaoRequest();
		offerDaoRequest.setCardNum(offersRequest.getCardNum());
		offerDaoRequest.setClientId(offersRequest.getClientId());
		offerDaoRequest.setChannelId(offersRequest.getChannelId());
//		offerDaoRequest.setTypeOfOffers(typeOfOffers);
		
		return null;
	}
	
	

}
