package com.navitsa.Reports;

public class GlTranctionReportBeen {

	private String journalno;
	private String doctype;
	private String document;
	private String primaryaccount;
	private String date;
	private Double dr;
	private Double cr;
	private String docNo;
	private String remark;

	public String getJournalno() {
		return journalno;
	}

	public void setJournalno(String journalno) {
		this.journalno = journalno;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPrimaryaccount() {
		return primaryaccount;
	}

	public void setPrimaryaccount(String primaryaccount) {
		this.primaryaccount = primaryaccount;
	}

	public Double getDr() {
		return dr;
	}

	public void setDr(Double dr) {
		this.dr = dr;
	}

	public Double getCr() {
		return cr;
	}

	public void setCr(Double cr) {
		this.cr = cr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
