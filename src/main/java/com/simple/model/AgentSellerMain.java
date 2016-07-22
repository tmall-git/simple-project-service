package com.simple.model;

import java.io.Serializable;

public class AgentSellerMain implements Serializable{

	private static final long serialVersionUID = 1L;

	private Double totalSell;
	private Integer orderCount;
	private Integer watchCount;
	private String sellerPhone;
	private String weiChat;
	
	public Double getTotalSell() {
		return totalSell;
	}
	public void setTotalSell(Double totalSell) {
		this.totalSell = totalSell;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getWatchCount() {
		return watchCount;
	}
	public void setWatchCount(Integer watchCount) {
		this.watchCount = watchCount;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getWeiChat() {
		return weiChat;
	}
	public void setWeiChat(String weiChat) {
		this.weiChat = weiChat;
	}
}
