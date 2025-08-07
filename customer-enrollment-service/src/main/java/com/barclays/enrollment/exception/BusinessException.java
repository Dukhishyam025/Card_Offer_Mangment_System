package com.barclays.enrollment.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String respCode;
	private String respMsg;
	
	public BusinessException(String respCode, String respMsg)
	{
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

}
