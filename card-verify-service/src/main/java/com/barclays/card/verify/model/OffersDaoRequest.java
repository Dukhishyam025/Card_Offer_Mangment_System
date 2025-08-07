package com.barclays.card.verify.model;

import lombok.Data;

@Data
public class OffersDaoRequest {
	
	private String cardNum;
	private String clientId;
	private String channelId;
	private String typeOfOffers;

}
