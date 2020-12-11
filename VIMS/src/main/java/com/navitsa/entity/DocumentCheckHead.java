package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="documentcheckhead")
public class DocumentCheckHead {

	@Id
	@Column(name="DocumentCheckHeadID")	
	private String  documentcheckheadid;

	@Column(name = "Vehicle_ID")
	String vehicleID;
	
	@Column(name="Date")	
	private String  date;
	
	@Column(name="Status")	
	private String  status;


	public String getDocumentcheckheadid() {
		return documentcheckheadid;
	}

	public void setDocumentcheckheadid(String documentcheckheadid) {
		this.documentcheckheadid = documentcheckheadid;
	}



	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	
}
