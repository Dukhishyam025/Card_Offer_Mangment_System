package com.barclays.offers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class OfferDetails {
	
	private String offerId;
	private String name;
	private String imageUrl;
	private String desc;
	private String date;
	private String status;
	

}
