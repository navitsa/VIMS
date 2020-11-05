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
@Table(name = "invoicehead")
public class InvoiceHead {

	@Id
	@Column(name = "invoiceNo")
	private String invoiceNo;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Register_ID", referencedColumnName = "V_Register_ID")
	private VehicleRegistration vRegisterID;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "InvoiceDate")
	private String invoiceDate;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "InvoiceTime")
	private String invoiceTime;
	@Column(name = "TestFee")
	private Long testFee;
	@Column(name = "NetTotal")
	private Long netTotal;
	@Column(name = "Description")
	private String description;
	@Column(name = "Status")
	private String status;
	@Column(name = "AppoID")
	private String appoID;
	@Column(name = "Balance")
	private Long balance;
	@Column(name = "payAmount")
	private Long payAmount;
	@Column(name = "payStatus")
	private String payStatus;
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public VehicleRegistration getvRegisterID() {
		return vRegisterID;
	}
	public void setvRegisterID(VehicleRegistration vRegisterID) {
		this.vRegisterID = vRegisterID;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceTime() {
		return invoiceTime;
	}
	public void setInvoiceTime(String invoiceTime) {
		this.invoiceTime = invoiceTime;
	}
	public Long getTestFee() {
		return testFee;
	}
	public void setTestFee(Long testFee) {
		this.testFee = testFee;
	}
	public Long getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(Long netTotal) {
		this.netTotal = netTotal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppoID() {
		return appoID;
	}
	public void setAppoID(String appoID) {
		this.appoID = appoID;
	}

	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}	
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public InvoiceHead() {
	}
	
	public InvoiceHead(String invoiceNo, VehicleRegistration vRegisterID, String invoiceDate, String invoiceTime,
			Long testFee, String description, String status, String appoID,String payStatus) {
		
		this.invoiceNo = invoiceNo;
		this.vRegisterID = vRegisterID;
		this.invoiceDate = invoiceDate;
		this.invoiceTime = invoiceTime;
		this.testFee = testFee;
		this.description = description;
		this.status = status;
		this.appoID = appoID;
		this.payStatus = payStatus;
	}
	
	
}
