package com.navitsa.Reports;

import java.util.List;



public class ContactForm {
	
	 String actype;
	 String payDueDate;
	 String toOrderOf;
	 String payTo;
	 String paytype;
	 String chequeNo;

	private List<Contact> contacts;

	public String getActype() {
		return actype;
	}

	public void setActype(String actype) {
		this.actype = actype;
	}

	public String getPayDueDate() {
		return payDueDate;
	}

	public void setPayDueDate(String payDueDate) {
		this.payDueDate = payDueDate;
	}

	public String getToOrderOf() {
		return toOrderOf;
	}

	public void setToOrderOf(String toOrderOf) {
		this.toOrderOf = toOrderOf;
	}

	public String getPayTo() {
		return payTo;
	}

	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	
}
