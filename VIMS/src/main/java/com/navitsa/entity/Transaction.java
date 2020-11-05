package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {

	@Id
	@Column(name="TR_ID")
	String trID;
	
	@Column(name="Status")
	String status;
	
	@Column(name="Remarks")
	String remarks;

	public String getTrID() {
		return trID;
	}

	public void setTrID(String trID) {
		this.trID = trID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Transaction(String trID) {
		
		this.trID = trID;
	}

	public Transaction() {
		super();
	}
	
}
