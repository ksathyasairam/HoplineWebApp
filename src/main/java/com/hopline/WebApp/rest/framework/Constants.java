package com.hopline.WebApp.rest.framework;

public class Constants {
	
	 //Base URL
    public static String SMS_BASE_URL = "https://sendotp.msg91.com/api";

	  // Your application key
	public static String SMS_API_KEY = "yumgrrIQZwiP1OV-m4V1LOibqeLR6STRtf7Yxp1ecE1HepiF2N7_tbfgDJM7wET4drJgAayr_UVXFKTCxT7eR1TBhZ6yjwlhDQ5L24o01KLUNdyHn-E0ACegF5WsmEe3qdkZg5Gl5cncfKmfoTQIZQ==";
	public static String SMS_AUTH_KEY = "127476A79wH6TQYos57f60529";
	public static String SENDER_ID = "Hoplin";

	public static final double BIG_ORDER_CALL_PRICE = 500;
	public static final double BIG_ORDER_PAY_PRICE = 1000;
	
	
	public static final String BIG_ORDER_PAY = "bigOrderPay";
	public static final String YOUR_ORDER = "yourOrder";
	
	
	
	
	public static final String ORDER_CREATOR_VENDOR = "vendor";
	public static final String ORDER_CREATOR_WEBSITE_CUSTOMER = "website-customer";
	
	public static final String SMS_CANCELLED_TEXT = "We apologise for the inconvenience but it looks like your order #%s is being cancelled by the restaurant. Comments from restaurant : \"%s\"";

	public static final String SMS_ORDER_READY_TEXT = "Your order #%s is ready";
	
	public static final String SMS_ORDER_CREATED_TEXT = "Your order has been accepted by vendor, your order number is #%s";

}
