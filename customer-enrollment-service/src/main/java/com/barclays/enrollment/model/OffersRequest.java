package com.barclays.enrollment.model;

import lombok.Data;
import lombok.Setter;

@Data
public class OffersRequest {
	
	private String cardNum;
	private String clientId;
	private String channelId;
	private String correlational;
	private String authToken;
	private String msgTs;
	
	

}
