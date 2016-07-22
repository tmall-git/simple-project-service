package com.simple.model;

import java.io.Serializable;

public class UserSellCount implements Serializable{

	private static final long serialVersionUID = 6980691915784332851L;

	public UserSellCount(Double totalSell, Double totalCharge,Double blance,String phone) {
		this.totalSell = (totalSell == null)?0d:totalSell;
		this.totalCharge = (totalCharge==null)?0d:totalCharge;
		this.balance = (blance == null)?0d:blance;
		this.phone = phone;
	}
	private double totalSell;
	private double totalCharge;
	private double balance;
	private String phone;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
