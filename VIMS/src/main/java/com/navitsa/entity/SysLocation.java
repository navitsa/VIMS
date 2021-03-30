package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "syslocation")
public class SysLocation {

	@Id
	@Column(name = "LocationCode")
	private String locationCode;
	
	@Column(name = "LocationName")
	private String locationName;
	
	@Column(name = "LocationVersion")
	private String locationVersion;
	
	@Column(name = "LocationOpenDate")
	private String locationOpenDate;

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationVersion() {
		return locationVersion;
	}

	public void setLocationVersion(String locationVersion) {
		this.locationVersion = locationVersion;
	}

	public String getLocationOpenDate() {
		return locationOpenDate;
	}

	public void setLocationOpenDate(String locationOpenDate) {
		this.locationOpenDate = locationOpenDate;
	}
	
	
	
	
}
