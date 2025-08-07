package com.barclays.offers.util;

public class OfferDetailsConstant {

	public static final String SUCCESS_RESP_CODE = "0";
	public static final String SUCCESS_RESP_MSG = "success";

	public static final String GENERIC_ERROR_CODE = "8888";
	public static final String GENERIC_ERROR_MSG = "Unkown error from service";

	public static final String DATA_ERROR = "9999";
	public static final String SYSTEM_ERROR = "Unknown error from database";

	public static final String DB_UNKNOWN_ERROR_CODE = "8888";
	public static final String DB_KNOWN_ERROR_MSG = "Unkown error from database";

	public static final String CARD_NUM = "cardnumber";
	public static final String CHANNEL_ID = "channelId";
	public static final String CLIENT_ID = "clientId";
	public static final String MSG_TS = "msgTs";
	public static final String CORRELATION_ID = "correlationId";
	public static final String AUTH_TOKEN = "authToken";

	/* stored procedure call*/
	public static final String SP_CALL = "CALL oms.GET_OFFER_V1(?,?,?,?,?)";
	
	/* database details*/
	public static final String DB_URL = "jdbc:mysql://localhost:3306/oms";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
}
