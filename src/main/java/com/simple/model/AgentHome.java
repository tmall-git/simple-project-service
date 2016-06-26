package com.simple.model;

import java.io.Serializable;

public class AgentHome implements Serializable{

	private static final long serialVersionUID = 6980691915784332851L;

	public AgentHome(int daifahuo, int tuihuozhong, int sellproduct,
			int nostock, int totalSellers, double chargepercent) {
		this.daifahuo = daifahuo;
		this.tuihuozhong = tuihuozhong;
		this.sellproduct = sellproduct;
		this.nostock = nostock;
		this.totalSellers = totalSellers;
		this.chargepercent = chargepercent;
	}
	private int daifahuo;
	private int tuihuozhong;
	private int sellproduct;
	private int nostock;
	private int totalSellers;
	private double chargepercent;
	public int getDaifahuo() {
		return daifahuo;
	}
	public void setDaifahuo(int daifahuo) {
		this.daifahuo = daifahuo;
	}
	public int getTuihuozhong() {
		return tuihuozhong;
	}
	public void setTuihuozhong(int tuihuozhong) {
		this.tuihuozhong = tuihuozhong;
	}
	public int getSellproduct() {
		return sellproduct;
	}
	public void setSellproduct(int sellproduct) {
		this.sellproduct = sellproduct;
	}
	public int getNostock() {
		return nostock;
	}
	public void setNostock(int nostock) {
		this.nostock = nostock;
	}
	public int getTotalSellers() {
		return totalSellers;
	}
	public void setTotalSellers(int totalSellers) {
		this.totalSellers = totalSellers;
	}
	public double getChargepercent() {
		return chargepercent;
	}
	public void setChargepercent(double chargepercent) {
		this.chargepercent = chargepercent;
	}
	
}
