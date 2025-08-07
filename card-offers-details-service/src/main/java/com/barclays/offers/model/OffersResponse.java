package com.barclays.offers.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value=Include.NON_NULL)
public class OffersResponse {
	
	private List<OfferDetails>offers;
	private StatusBlock statusBlock;
	

}
