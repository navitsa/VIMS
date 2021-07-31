package com.navitsa.Reports;

public class GLTransactionReportBean {

	private String vendorORCustomer;
	private String date;
	private String invoiceNo;
	private String document;
	private String glNo;
	private String glAccountNo;
	private String glAccount;
	private double credit;
	private double debit;

	public String getVendorORCustomer() {
		return vendorORCustomer;
	}

	public void setVendorORCustomer(String vendorORCustomer) {
		this.vendorORCustomer = vendorORCustomer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getGlNo() {
		return glNo;
	}

	public void setGlNo(String glNo) {
		this.glNo = glNo;
	}

	public String getGlAccountNo() {
		return glAccountNo;
	}

	public void setGlAccountNo(String glAccountNo) {
		this.glAccountNo = glAccountNo;
	}

	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}
}