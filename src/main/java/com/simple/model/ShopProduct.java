package com.simple.model;

import java.io.Serializable;

public class ShopProduct implements Serializable{

	private static final long serialVersionUID = 1L;
	private String productName;
	private String price;
	private String charge;
	private String image;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
}
