package com.barclays.enrollment.dao;

import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.SystemException;
import com.barclays.enrollment.model.OffersDaoRequest;
import com.barclays.enrollment.model.OffersDaoResponse;


public interface IOffersDao {
	
	OffersDaoResponse getOffers(OffersDaoRequest daoRequest) throws BusinessException, SystemException;

}
