package com.barclays.card.verify.dao;

import com.barclays.card.verify.exception.BusinessException;
import com.barclays.card.verify.exception.SystemException;
import com.barclays.card.verify.model.OffersDaoRequest;
import com.barclays.card.verify.model.OffersDaoResponse;


public interface IOffersDao {
	
	OffersDaoResponse getOffers(OffersDaoRequest daoRequest) throws BusinessException, SystemException;

}
