package com.barclays.offers.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.offers.model.CardVerifyResponse;
import com.barclays.offers.model.EnrollmentResponse;
import com.barclays.offers.model.OfferDetails;
import com.barclays.offers.model.OfferDetailsDao;
import com.barclays.offers.model.OffersDaoResponse;
import com.barclays.offers.model.OffersResponse;
import com.barclays.offers.model.StatusBlock;

@Component
public class OffersResponseBuilder {

	/**
	 * Description : Prepare the OffersResponse with the help of daoResp
	 * 
	 * @param enrollmentResp
	 * @param cardVerifyResp
	 * @param daoResp
	 * @return OffersResponse
	 */

	public OffersResponse buildOffersResp(EnrollmentResponse enrollmentResp, CardVerifyResponse cardVerifyResp,
			OffersDaoResponse daoResp) {

		// service response
		OffersResponse offersResponse = new OffersResponse();

		List<OfferDetails> offersList = new ArrayList<OfferDetails>();

		for (OfferDetailsDao offerDaoDtls : daoResp.getOfferDaoList()) {

			OfferDetails offerDetails = new OfferDetails();

//			offerDetails.setDate(offerDaoDtls.getStdate());
			offerDetails.setDesc(offerDaoDtls.getDesc());
			offerDetails.setImageUrl(offerDaoDtls.getImageUrl());
			offerDetails.setName(offerDaoDtls.getName());
			offerDetails.setOfferId(offerDaoDtls.getOfferId());
			offerDetails.setStatus(offerDaoDtls.getStatus());

			offersList.add(offerDetails);

		}
		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(daoResp.getRespCode());
		statusBlock.setRespMsg(daoResp.getRespMsg());
		offersResponse.setStatusBlock(statusBlock);
		offersResponse.setOffers(offersList);

		return offersResponse;
	}

	public OffersResponse buildOffersResp(String respCode, String respMsg) {
		OffersResponse offersResponse = new OffersResponse();

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);

		offersResponse.setStatusBlock(statusBlock);
		return offersResponse;
	}

}
