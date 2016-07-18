package com.simple.model;

import java.io.Serializable;

public class ShopProduct implements Serializable{

	private static final long serialVersionUID = 1L;
	private String productName;
	private double price;
	private double charge;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
}
