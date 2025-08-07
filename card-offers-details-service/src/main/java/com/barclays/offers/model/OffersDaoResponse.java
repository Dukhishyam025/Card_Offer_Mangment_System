package com.barclays.offers.model;

import java.util.List;

import lombok.Data;

@Data
public class OffersDaoResponse {
	
	private String respCode;
	private String respMsg;
	
	private List<OfferDetailsDao> offerDaoList;

}
