package com.barclays.card.verify.model;

import lombok.Data;

@Data
public class EnrollmentRequest {

	private String cardnum;
	private String date;
	private String name;
	
}
