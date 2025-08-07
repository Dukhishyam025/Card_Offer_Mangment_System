package com.barclays.card.verify.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OffersInvalidRequestDataException extends Exception{

	private static final long serialVersionUID = 1L;
	private String respCode;
	private String respMsg;
	
	public OffersInvalidRequestDataException(String respCode, String respMsg)
	{
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
}
