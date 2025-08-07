package com.barclays.offers.dao;

import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.OffersDaoRequest;
import com.barclays.offers.model.OffersDaoResponse;


public interface IOffersDao {
	
	OffersDaoResponse getOffers(OffersDaoRequest daoRequest) throws BusinessException, SystemException;

}
