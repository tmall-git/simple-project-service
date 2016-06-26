package com.simple.model;

import java.io.Serializable;

public class UserSellCount implements Serializable{

	private static final long serialVersionUID = 6980691915784332851L;

	public UserSellCount(double totalSell, double totalCharge) {
		this.totalSell = totalSell;
		this.totalCharge = totalCharge;
	}
	private double totalSell;
	private double totalCharge;
	public double getTotalSell() {
		return totalSell;
	}
	public void setTotalSell(double totalSell) {
		this.totalSell = totalSell;
	}
	public double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
}
