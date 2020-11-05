package com.navitsa.Reports;

import java.util.List;

public class Contact {

	private String glAccNo;
	private double amount;
	private String remarks;

	public Contact() {
	}

	public Contact(String glAccNo, double amount, String remarks) {
		this.glAccNo = glAccNo;
		this.amount = amount;
		this.remarks = remarks;
	}

	public String getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(String glAccNo) {
		this.glAccNo = glAccNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}





}
