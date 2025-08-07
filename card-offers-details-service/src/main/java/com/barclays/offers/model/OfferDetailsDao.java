package com.barclays.offers.model;

import lombok.Data;

@Data
public class OfferDetailsDao {
	
	private String offerId;
	private String name;
	private String imageUrl;
	private String offerType;
	private String desc;
	private String stdate;
	private String endate;
	private String remarks;
	private String status;
	

}
