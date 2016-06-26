package com.simple.model;

import java.util.Date;

/**提款表
 * tmall_account
 * @author kaixiang
 *
 */
public class Account extends AbstractBaseModel{

	private static final long serialVersionUID = 3087624468698518327L;
	
	private String userPhone;
	private int bankId;
	private String bankAccount;
	private int bankAccountNo;
	private double cashAmount;
	private Date cashTime;
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public int getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(int bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public Date getCashTime() {
		return cashTime;
	}
	public void setCashTime(Date cashTime) {
		this.cashTime = cashTime;
	}
	public Account() {
		super();
	}
}
