package com.inautix.training.atmcashposition.domain;

public class Customer {
	private int cardnum,pinnum,accnum,balance;
	private String acctype , cusname;
	public int getCardnum() {
		return cardnum;
	}
	public void setCardnum(int cardnum) {
		this.cardnum = cardnum;
	}
	public int getPinnum() {
		return pinnum;
	}
	public void setPinnum(int pinnum) {
		this.pinnum = pinnum;
	}
	public int getAccnum() {
		return accnum;
	}
	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	
	

}
