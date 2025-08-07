package com.barclays.card.verify.verify.svcClient;

import org.springframework.stereotype.Component;

import com.barclays.card.verify.model.CardVerifyRequest;
import com.barclays.card.verify.model.CardVerifyResponse;

@Component
public interface ICardVerifyServiceClient {
	
	CardVerifyResponse verifyCard(CardVerifyRequest verifyRequest);
	

}

