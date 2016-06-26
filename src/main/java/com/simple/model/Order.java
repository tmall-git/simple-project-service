package com.simple.model;

import java.util.Date;

public class Order extends AbstractBaseModel implements java.io.Serializable{
	
	private static final long serialVersionUID = 5784715568286725038L;
	
	private String order_no;
	private String user_phone;
	private int product_id; 
	private String product_name;
	private String user_name;
	private String address;
	private int product_count; 
	private double price;
	private String owner;
	private String seller;
	private Date create_time;
	private int order_status; 
	private String expressage;
	private String expressage_name;
	private String expressage_no;
	private Date expressage_time;
	private int change_status; 
	private Date change_time;
	private String change_remark;
	private int reject_status; 
	private Date reject_time;
	private String reject_remark;
	private int pay_status; 
	private Date pay_time;
	private String product_image;
	private double total_price;
	private double total_charge;
	
	
	
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getExpressage() {
		return expressage;
	}
	public void setExpressage(String expressage) {
		this.expressage = expressage;
	}
	public String getExpressage_name() {
		return expressage_name;
	}
	public void setExpressage_name(String expressage_name) {
		this.expressage_name = expressage_name;
	}
	public String getExpressage_no() {
		return expressage_no;
	}
	public void setExpressage_no(String expressage_no) {
		this.expressage_no = expressage_no;
	}
	public Date getExpressage_time() {
		return expressage_time;
	}
	public void setExpressage_time(Date expressage_time) {
		this.expressage_time = expressage_time;
	}
	public int getChange_status() {
		return change_status;
	}
	public void setChange_status(int change_status) {
		this.change_status = change_status;
	}
	public Date getChange_time() {
		return change_time;
	}
	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}
	public String getChange_remark() {
		return change_remark;
	}
	public void setChange_remark(String change_remark) {
		this.change_remark = change_remark;
	}
	public int getReject_status() {
		return reject_status;
	}
	public void setReject_status(int reject_status) {
		this.reject_status = reject_status;
	}
	public Date getReject_time() {
		return reject_time;
	}
	public void setReject_time(Date reject_time) {
		this.reject_time = reject_time;
	}
	public String getReject_remark() {
		return reject_remark;
	}
	public void setReject_remark(String reject_remark) {
		this.reject_remark = reject_remark;
	}
	public int getPay_status() {
		return pay_status;
	}
	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public double getTotal_charge() {
		return total_charge;
	}
	public void setTotal_charge(double total_charge) {
		this.total_charge = total_charge;
	} 
}
