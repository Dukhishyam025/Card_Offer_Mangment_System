package com.barclays.enrollment.verify.svcClient;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.model.CardVerifyRequest;
import com.barclays.enrollment.model.CardVerifyResponse;

@Component
public interface ICardVerifyServiceClient {
	
	CardVerifyResponse verifyCard(CardVerifyRequest verifyRequest);
	

}

