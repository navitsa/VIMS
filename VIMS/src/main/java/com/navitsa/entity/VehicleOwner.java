package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vehicle_owner")
public class VehicleOwner {

	@Id
	@Column(name = "Owner_ID")
	private String ownerID;

	@NotEmpty(message = "Please select title")
	@Column(name = "Title")
	private String title;
	
	@NotEmpty(message = "Please enter owner name")
	@Column(name = "Owner_Name")
	private String ownerName;

	@NotEmpty(message = "Please enter contact no")
	@Column(name = "Contact_No")
	private String contactNo;

	@Column(name = "PostalBox")
	private String postalBox;
	
	@Column(name = "Add_01")
	private String add01;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "State_id", referencedColumnName = "State_id")
	private CountryState stateid;

	@Column(name = "City")
	private String city;

	@Column(name = "Email")
	private String email;
	
	@NotEmpty
	@Column(name = "Status")
	private String status;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Country_Code", referencedColumnName = "Country_Code")
	private CountryMaster countryCode;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_ID", referencedColumnName = "Vehicle_ID")
	private VehicleMaster vehicleID;	

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAdd01() {
		return add01;
	}

	public void setAdd01(String add01) {
		this.add01 = add01;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CountryMaster getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryMaster countryCode) {
		this.countryCode = countryCode;
	}

	public 	VehicleMaster getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(VehicleMaster vehicleID) {
		this.vehicleID = vehicleID;
	} 

	public VehicleOwner(String ownerID, String ownerName, String contactNo, String add01, 	CountryState stateid, String city,
			String email, String status, CountryMaster countryCode, VehicleMaster vehicleID) {
		this.ownerID = ownerID;
		this.ownerName = ownerName;
		this.contactNo = contactNo;
		this.add01 = add01;
		this.stateid = stateid;
		this.city = city;
		this.email = email;
		this.status = status;
		this.countryCode = countryCode;
		this.vehicleID = vehicleID;
	}

	public VehicleOwner() {
	}

	public VehicleOwner(String ownerID) {
		this.ownerID = ownerID;
	}

	public CountryState getStateid() {
		return stateid;
	}

	public void setStateid(CountryState stateid) {
		this.stateid = stateid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostalBox() {
		return postalBox;
	}

	public void setPostalBox(String postalBox) {
		this.postalBox = postalBox;
	}
	
}
