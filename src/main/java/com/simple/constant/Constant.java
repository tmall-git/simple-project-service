package com.simple.constant;

public class Constant {

	/*session用户**/
	public static final String CURRENT_USER = "_sys_current_user";
	
	public static final int ALLOW_SELL = 1;
	public static final int NOT_ALLOW_SELL = 2;
	
	/*产品状态**/
	public static final int PRODUCT_STATUS_CREATE = 1;
	public static final int PRODUCT_STATUS_ONLINE  =2;
	public static final int PRODUCT_STATUS_OFFLINE = 3;
	public static final int PRODUCT_STATUS_DELETE = 4;
	
	/*订单状态**/
	public static final int ORDER_STATUS_TOSEND = 1;
	public static final int ORDER_STATUS_SEND = 2;
	public static final int ORDER_STATUS_FINISHED = 3;
	public static final int ORDER_STATUS_CANCEL = 4;
	public static final int ORDER_STATUS_REGECT = 5;
	public static final int ORDER_STATUS_REGECT_REFUSE = 6;
	public static final int ORDER_STATUS_UNPAY = 7;
	
	public static final double CHARGE_DEFAULT = 30.00d;
	
	

}
