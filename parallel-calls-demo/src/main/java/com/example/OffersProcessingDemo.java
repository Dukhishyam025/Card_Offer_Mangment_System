package com.example;

import java.util.ArrayList;
import java.util.List;

public class OffersProcessingDemo {

	public static void main(String[] args) {
		
	List<OfferDetails> offereDtlsResult = new ArrayList<OfferDetails>();

	List<OfferDetails> mOfferList = new ArrayList<OfferDetails>();
	List<OfferDetails> pOfferList = new ArrayList<OfferDetails>();
	List<OfferDetails> gOfferList = new ArrayList<OfferDetails>();

	
	OfferDetails goffers1= new OfferDetails();
	goffers1.setOid("111");
	goffers1.setName("mobile");
	goffers1.setDesc("good");
	goffers1.setStatus("active");
	goffers1.setEndDate("30-July-2025");
	
	OfferDetails goffers2 = new OfferDetails();
	goffers2.setOid("222");
	goffers2.setName("mobile");
	goffers2.setDesc("good");
	goffers2.setStatus("active");
	goffers2.setEndDate("30-July-2025");
	
	gOfferList.add(goffers1);
	gOfferList.add(goffers2);
	
	OfferDetails poffers1 = new OfferDetails();
	poffers1.setOid("111");
	poffers1.setName("mobile");
	poffers1.setDesc("good");
	poffers1.setStatus("active");
	poffers1.setEndDate("30-July-2025");
	
	OfferDetails poffers2 = new OfferDetails();
	poffers2.setOid("222");
	poffers2.setName("mobile");
	poffers2.setDesc("good");
	poffers2.setStatus("active");
	poffers2.setEndDate("30-July-2025");
	
	pOfferList.add(poffers1);
	pOfferList.add(poffers2);
	
	OfferDetails moffers = new OfferDetails();
	
	moffers.setOid("111");
	moffers.setName("mobile");
	moffers.setDesc("good");
	moffers.setStatus("active");
	moffers.setEndDate("30-July-2025");
	
	mOfferList.add(moffers);
	
	//1.write all the scenarios in jdk8 stream api
	
	
	
	}
}
