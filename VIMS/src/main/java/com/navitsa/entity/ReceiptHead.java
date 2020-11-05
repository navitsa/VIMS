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
@Table(name = "receipthead")
public class ReceiptHead {

	@Id
	@Column(name = "recNo")
	private String recNo;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Register_ID", referencedColumnName = "V_Register_ID")
	private VehicleRegistration vRegisterID;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "recDate")
	private String recDate;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "recTime")
	private String recTime;
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
	
	

	public String getRecNo() {
		return recNo;
	}

	public void setRecNo(String recNo) {
		this.recNo = recNo;
	}

	public VehicleRegistration getvRegisterID() {
		return vRegisterID;
	}

	public void setvRegisterID(VehicleRegistration vRegisterID) {
		this.vRegisterID = vRegisterID;
	}

	public String getRecDate() {
		return recDate;
	}

	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}

	public String getRecTime() {
		return recTime;
	}

	public void setRecTime(String recTime) {
		this.recTime = recTime;
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

	public ReceiptHead() {
		
	}

	public String getAppoID() {
		return appoID;
	}

	public void setAppoID(String appoID) {
		this.appoID = appoID;
	}

	public ReceiptHead(String recNo, VehicleRegistration vRegisterID, String recDate, String recTime, Long testFee,
			 String description, String appoID, String status) {
		this.recNo = recNo;
		this.vRegisterID = vRegisterID;
		this.recDate = recDate;
		this.recTime = recTime;
		this.testFee = testFee;
		this.description = description;
		this.appoID = appoID;
		this.status = status;
	}

}
