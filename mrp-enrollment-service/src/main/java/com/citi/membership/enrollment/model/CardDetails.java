package com.citi.membership.enrollment.model;

public class CardDetails {
	
	private String cardNum;
	private boolean primary;
	private String productType;
	private String fname;
	private String lname;
	private String status;
	private String pastDue;
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPastDue() {
		return pastDue;
	}
	public void setPastDue(String pastDue) {
		this.pastDue = pastDue;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNum=" + cardNum + ", primary=" + primary + ", productType=" + productType + ", fname="
				+ fname + ", lname=" + lname + ", status=" + status + ", pastDue=" + pastDue + "]";
	}
	
	
}
