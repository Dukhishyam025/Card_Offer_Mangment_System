package com.barclays.offers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.OffersInvalidRequestDataException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.OffersRequest;
import com.barclays.offers.model.OffersResponse;
import com.barclays.offers.service.IOffersService;
import com.barclays.offers.util.OfferDetailsConstant;
import com.barclays.offers.validator.OfferDetailsValidator;

@RestController
@RequestMapping("/v1")
public class OfferDetailsController {

	@Autowired
	OfferDetailsValidator offerDetailsValidator;

	@Autowired
	IOffersService offersService;

	/**
	 * 
	 * @param cardNum
	 * @param clientId
	 * @param channelid
	 * @param msgTs
	 * @param correlational
	 * @param authToken
	 * @return OffersResponse
	 * @throws OffersInvalidRequestDataException 
	 * @throws SystemException 
	 * @throws BusinessException 
	 */

	@GetMapping("/offers/{cardnumber}")
	public OffersResponse getOffers(@PathVariable(OfferDetailsConstant.CARD_NUM) String cardNum,
			@RequestHeader(name = OfferDetailsConstant.CLIENT_ID, required = false) String clientId,
			@RequestHeader(name = OfferDetailsConstant.CHANNEL_ID, required = false) String channelid,
			@RequestHeader(name = OfferDetailsConstant.MSG_TS, required = false) String msgTs,
			@RequestHeader(name = OfferDetailsConstant.CORRELATION_ID, required = false) String correlational,
			@RequestHeader(name = OfferDetailsConstant.AUTH_TOKEN, required = false) String authToken) throws OffersInvalidRequestDataException, BusinessException, SystemException {

		OffersRequest offersRequest = new OffersRequest();
		offersRequest.setCardNum(cardNum);
		offersRequest.setChannelId(channelid);
		offersRequest.setClientId(clientId);
		offersRequest.setCorrelational(correlational);
		offersRequest.setAuthToken(authToken);
		offersRequest.setMsgTs(msgTs);

		// 1.validate the request

		offerDetailsValidator.validateRequest(offersRequest);

		// 2.prepare the request for service layer

		// 3.call the service layer and get the response
   
		OffersResponse offersResponse = offersService.getOffers(offersRequest);

		return offersResponse;

	}

}
