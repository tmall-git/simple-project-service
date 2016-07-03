package com.simple.model;

public class SellerListVO implements java.io.Serializable{

	private static final long serialVersionUID = -2046633238913528568L;
	
	private String wechatName;
	private Double sellerAmount;
	private Integer dealCount;
	private Integer productCount;
	
	public String getWechatName() {
		return wechatName;
	}
	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}
	public Double getSellerAmount() {
		return sellerAmount;
	}
	public void setSellerAmount(Double sellerAmount) {
		this.sellerAmount = sellerAmount;
	}
	public Integer getDealCount() {
		return dealCount;
	}
	public void setDealCount(Integer dealCount) {
		this.dealCount = dealCount;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public SellerListVO(String wechatName, Double sellerAmount, Integer dealCount, Integer productCount) {
		super();
		this.wechatName = wechatName;
		this.sellerAmount = sellerAmount;
		this.dealCount = dealCount;
		this.productCount = productCount;
	}
	
}
