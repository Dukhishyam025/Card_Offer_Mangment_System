package com.barclays.card.verify.validator;

import org.springframework.stereotype.Component;

import com.barclays.card.verify.exception.OffersInvalidRequestDataException;
import com.barclays.card.verify.model.OffersRequest;

@Component
public class OfferDetailsValidator {

	public void validateRequest(OffersRequest offersRequest) throws OffersInvalidRequestDataException {

		if (offersRequest.getClientId() == null || " ".equals(offersRequest.getClientId())) {
			throw new OffersInvalidRequestDataException("offsvc001", "Client id invalid");
		}

		if (offersRequest.getChannelId() == null || " ".equals(offersRequest.getChannelId())) {
			throw new OffersInvalidRequestDataException("offsvc001", "Channel id invalid");
		}

		if (offersRequest.getCardNum() == null
				|| " ".equals(offersRequest.getCardNum()) || offersRequest.getCardNum().length() < 16) {
			throw new OffersInvalidRequestDataException("offsvc001", "Card Num id invalid");
		}
		
		//TODO : apply validations for all the mandatory elements
	}

}
