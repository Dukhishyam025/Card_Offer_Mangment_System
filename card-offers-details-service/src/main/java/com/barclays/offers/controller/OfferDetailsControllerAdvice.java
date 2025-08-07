package com.barclays.offers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.offers.builder.OffersResponseBuilder;
import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.OffersInvalidRequestDataException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.OffersResponse;
import com.barclays.offers.model.StatusBlock;
import com.barclays.offers.util.OfferDetailsConstant;

@ControllerAdvice
public class OfferDetailsControllerAdvice {

	@Autowired
	OffersResponseBuilder offersResponseBuilder;

	@ExceptionHandler(value = OffersInvalidRequestDataException.class)
	@ResponseBody
	public OffersResponse handlerRequestInvalidException(OffersInvalidRequestDataException exception) {

		return offersResponseBuilder.buildOffersResp(exception.getRespCode(), exception.getRespMsg());

	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public OffersResponse handleBusinessException(BusinessException exception) {

		return offersResponseBuilder.buildOffersResp(exception.getRespCode(), exception.getRespMsg());
	}

	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
	public OffersResponse handleSystemException(SystemException exception) {

		return offersResponseBuilder.buildOffersResp(exception.getRespCode(), exception.getRespMsg());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public OffersResponse handleGenericException(Exception exception) {

		return offersResponseBuilder.buildOffersResp(OfferDetailsConstant.GENERIC_ERROR_CODE,OfferDetailsConstant.GENERIC_ERROR_MSG);
	}

}
