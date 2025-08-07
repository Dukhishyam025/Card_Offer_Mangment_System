package com.barclays.card.verify.service;

import com.barclays.card.verify.exception.BusinessException;
import com.barclays.card.verify.exception.SystemException;
import com.barclays.card.verify.model.OffersRequest;
import com.barclays.card.verify.model.OffersResponse;

public interface IOffersService {
	
	OffersResponse getOffers(OffersRequest offersRequest) throws BusinessException, SystemException;

}
