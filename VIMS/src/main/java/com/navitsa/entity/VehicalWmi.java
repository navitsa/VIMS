package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "v_wmi")
public class VehicalWmi {
	
	@Id
	@Column(name = "wmiid")
	private String wmiid;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_Make_ID",referencedColumnName = "Vehicle_Make_ID")
	private VehicleMake vehicleMakeID;
	
	@Column(name="country")
	private String country;
	
	@Column(name="remarks")
	private String remarks;

	public String getWmiid() {
		return wmiid;
	}

	public void setWmiid(String wmiid) {
		this.wmiid = wmiid;
	}

	public VehicleMake getVehicleMakeID() {
		return vehicleMakeID;
	}

	public void setVehicleMakeID(VehicleMake vehicleMakeID) {
		this.vehicleMakeID = vehicleMakeID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
