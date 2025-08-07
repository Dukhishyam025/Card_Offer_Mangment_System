package com.barclays.offers.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JasoSerializationDemo {
	
	public static void main(String[]args) throws JsonProcessingException
	{
		OffersResponse offersResponse = new OffersResponse();
		
		StatusBlock statusBlock =new StatusBlock();
		statusBlock.setRespCode("0");
		statusBlock.setRespMsg("success");
		
		List<OfferDetails> offersList = new ArrayList<OfferDetails>();
		
		OfferDetails offers1 = new OfferDetails();
	    offers1.setDate("01-06-2025");
	    offers1.setDesc("good");
	    offers1.setImageUrl("");
	    offers1.setName("apple");
	    offers1.setOfferId("425224");
	    offers1.setStatus("active");
	    
	    OfferDetails offers2 = new OfferDetails();
	    offers2.setDate("02-06-2025");
	    offers2.setDesc("good");
	    offers2.setImageUrl("");
	    offers2.setName("apple");
	    offers2.setOfferId("425224");
	    offers2.setStatus("active");
	    
	    OfferDetails offers3 = new OfferDetails();
	    offers3.setDate("01-06-2025");
	    offers3.setDesc("good");
	    offers3.setImageUrl("");
	    offers3.setName("apple");
	    offers3.setOfferId("425224");
	    offers3.setStatus("active");
	    
	    OfferDetails offers4 = new OfferDetails();
	    offers4.setDate("01-06-2025");
	    offers4.setDesc("good");
	    offers4.setImageUrl("");
	    offers4.setName("apple");
	    offers4.setOfferId("425224");
	    offers4.setStatus("active");
	    
	    offersList.add(offers1);
	    offersList.add(offers2);
	    offersList.add(offers3);
	    offersList.add(offers4);
		
		offersResponse.setStatusBlock(statusBlock);
		offersResponse.setOffers(offersList);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(offersResponse);
		
		System.out.println("jsonData is " + jsonData);
		
	}

}
