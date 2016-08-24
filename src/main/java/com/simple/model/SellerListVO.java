package com.simple.model;

public class SellerListVO implements java.io.Serializable{

	private static final long serialVersionUID = -2046633238913528568L;
	
	private String userPhone;		//用户电话
	private String wechatName;		//用户名称
	private String nickName;
	private Double sellerAmount;	//代销金额
	private Integer dealCount;		//成交笔数
	private Integer productCount;	//商品总数
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public SellerListVO(){};
	
	public SellerListVO(String userPhone, String wechatName, Double sellerAmount, Integer dealCount, Integer productCount) {
		super();
		this.userPhone = userPhone;
		this.wechatName = wechatName;
		this.sellerAmount = (sellerAmount==null)?0d:sellerAmount;
		this.dealCount = (dealCount==null)?0:dealCount;
		this.productCount = (productCount==null)?0:productCount;
	}
	
}
