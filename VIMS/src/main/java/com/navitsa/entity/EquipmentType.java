package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "equipment_type")
public class EquipmentType {

	@Id
	@Column(name = "Eq_Type_ID")
	String eqTypeID;
	
	@NotEmpty(message = "Please enter a equipment type")
	@Column(name = "Eq_Type")
	String eqType;
	
	@Column(name = "Status")
	String status;
	
	@Column(name = "Remarks")
	String remark;

	public EquipmentType() {
	}

	public EquipmentType(String eqTypeID) {
		this.eqTypeID = eqTypeID;
	}

	public String getEqTypeID() {
		return eqTypeID;
	}

	public void setEqTypeID(String eqTypeID) {
		this.eqTypeID = eqTypeID;
	}

	public String getEqType() {
		return eqType;
	}

	public void setEqType(String eqType) {
		this.eqType = eqType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public EquipmentType(String eqTypeID, String eqType, String status, String remark) {
		
		this.eqTypeID = eqTypeID;
		this.eqType = eqType;
		this.status = status;
		this.remark = remark;
	}

	
	
	
}
