package com.example.dao;

import com.example.model.Offers;

public class POffersDao {
	
public Offers getOffers(String cardnum){
		
		Offers offers1 = new Offers();
		offers1.setOid("111");
		offers1.setName("mobile");
		offers1.setImageUrl("");
		offers1.setDesc("good");
		offers1.setExpDate("22-July-2025");
		
		return offers1;
	}

}
