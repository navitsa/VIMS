package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="center_type")
public class CenterTypes {
	
	@Id
	@Column(name="Center_Type_ID")
	String centerTypeID;
	
	@NotEmpty(message = "Please enter a center type")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Center_Type")
	String centerType;
	
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Remarks")
	String remarks;
	
	@Column(name="Status")
	String status;

	public String getCenterTypeID() {
		return centerTypeID;
	}

	public void setCenterTypeID(String centerTypeID) {
		this.centerTypeID = centerTypeID;
	}

	public String getCenterType() {
		return centerType;
	}

	public void setCenterType(String centerType) {
		this.centerType = centerType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public CenterTypes(String centerTypeID) {
		this.centerTypeID = centerTypeID;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CenterTypes() {
	}
	
}
