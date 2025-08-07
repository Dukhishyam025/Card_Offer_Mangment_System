package com.barclays.offers.verify.svcClient;

import org.springframework.stereotype.Component;

import com.barclays.offers.model.CardVerifyRequest;
import com.barclays.offers.model.CardVerifyResponse;

@Component
public interface ICardVerifyServiceClient {
	
	CardVerifyResponse verifyCard(CardVerifyRequest verifyRequest);
	

}

