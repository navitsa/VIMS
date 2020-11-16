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

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_ID", referencedColumnName = "Vehicle_ID")
	private VehicleMaster vehicleID;
	
	@Column(name="Date")	
	private String  date;
	
	@Column(name="Status")	
	private String  status;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ocrid", referencedColumnName = "ocrid")
	private OcrDetails ocrid;

	public String getDocumentcheckheadid() {
		return documentcheckheadid;
	}

	public void setDocumentcheckheadid(String documentcheckheadid) {
		this.documentcheckheadid = documentcheckheadid;
	}

	public VehicleMaster getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(VehicleMaster vehicleID) {
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

	public OcrDetails getOcrid() {
		return ocrid;
	}

	public void setOcrid(OcrDetails ocrid) {
		this.ocrid = ocrid;
	}


	
}
