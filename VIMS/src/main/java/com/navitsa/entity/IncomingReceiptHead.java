package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "incomingreceipthead")
public class IncomingReceiptHead {

	@Id
	@Column(name = "InRecNo")
	private String inRecNo;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Cusid", referencedColumnName = "id")
	private Customer cusid;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Center_ID", referencedColumnName = "Center_ID")
	private CenterMaster center_ID;
	
	@Column(name = "InRecDate")
	private String inRecDate;

	@Column(name = "InRecTime")
	private String inRecTime;

	@Column(name = "TotDueAmt")
	private Long totDueAmt;
	
	@Column(name = "PayAmt")
	private Long payAmt;
	
	@Column(name = "Balance")
	private Long balance;

	@Column(name = "PayType")
	private String payType;

	@Column(name = "PayName")
	private String payName;

	@Column(name = "PayNumber")
	private String payNumber;

	@Column(name = "PayGlacc")
	private String payGlacc;

	@Column(name = "Date")
	private String date;

	@Column(name = "BankCharg")
	private Long bankCharg;

	@Column(name = "Status")
	private String status;

	public String getInRecNo() {
		return inRecNo;
	}

	public void setInRecNo(String inRecNo) {
		this.inRecNo = inRecNo;
	}

	public Customer getCusid() {
		return cusid;
	}

	public void setCusid(Customer cusid) {
		this.cusid = cusid;
	}

	public String getInRecDate() {
		return inRecDate;
	}

	public void setInRecDate(String inRecDate) {
		this.inRecDate = inRecDate;
	}

	public String getInRecTime() {
		return inRecTime;
	}

	public void setInRecTime(String inRecTime) {
		this.inRecTime = inRecTime;
	}

	public Long getTotDueAmt() {
		return totDueAmt;
	}

	public void setTotDueAmt(Long totDueAmt) {
		this.totDueAmt = totDueAmt;
	}

	public Long getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(Long payAmt) {
		this.payAmt = payAmt;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

	public String getPayGlacc() {
		return payGlacc;
	}

	public void setPayGlacc(String payGlacc) {
		this.payGlacc = payGlacc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getBankCharg() {
		return bankCharg;
	}

	public void setBankCharg(Long bankCharg) {
		this.bankCharg = bankCharg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public CenterMaster getCenter_ID() {
		return center_ID;
	}

	public void setCenter_ID(CenterMaster center_ID) {
		this.center_ID = center_ID;
	}

	public IncomingReceiptHead() {
		
	}
	
	
}
