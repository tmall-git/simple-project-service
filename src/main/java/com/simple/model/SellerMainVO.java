package com.simple.model;

import java.util.List;

public class SellerMainVO implements java.io.Serializable{
	
	private static final long serialVersionUID = -5010299911543691128L;
	
	// head
	private Double totalSellAmount; 		//总销售额
	private Double totalChargeAmount; 		//总提成额
	private Double balance;					//余额
	private Double withdrawAmount;			//可提现额度
	
	//middle
	private Integer tradingOrderCount;		//交易中订单
	private Integer returningOrderCount;	//退货中订单
	private Integer ownerCount;				//代销店铺数
	
	public Double getTotalSellAmount() {
		return totalSellAmount;
	}
	public void setTotalSellAmount(Double totalSellAmount) {
		this.totalSellAmount = totalSellAmount;
	}
	public Double getTotalChargeAmount() {
		return totalChargeAmount;
	}
	public void setTotalChargeAmount(Double totalChargeAmount) {
		this.totalChargeAmount = totalChargeAmount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(Double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public Integer getTradingOrderCount() {
		return tradingOrderCount;
	}
	public void setTradingOrderCount(Integer tradingOrderCount) {
		this.tradingOrderCount = tradingOrderCount;
	}
	public Integer getReturningOrderCount() {
		return returningOrderCount;
	}
	public void setReturningOrderCount(Integer returningOrderCount) {
		this.returningOrderCount = returningOrderCount;
	}
	public Integer getOwnerCount() {
		return ownerCount;
	}
	public void setOwnerCount(Integer ownerCount) {
		this.ownerCount = ownerCount;
	}
}
