package com.navitsa.entity;

import java.util.Date;

public class AppointmentForm {
	
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentTime;
	private TestLaneHead lane;
	
	private String vehicleID;
	private VehicleModel vmodel;
	private String manufactureYear;
	private String registeredYear;
	private String chassisNo;
	private String engineNo;
	private String engineCapacity;
	private FuelType ftype;
	private String noWheel;
	private String emissionNorms;
	
	private String customerID;
	private String mobileNo;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String customer_owner_status;
	private String cusTitle;
	private String postalCode;
	private String city;
	private CountryState stateid;
	private TestCategory categoryId;
	
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public TestLaneHead getLane() {
		return lane;
	}
	public void setLane(TestLaneHead lane) {
		this.lane = lane;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public VehicleModel getVmodel() {
		return vmodel;
	}
	public void setVmodel(VehicleModel vmodel) {
		this.vmodel = vmodel;
	}
	public String getManufactureYear() {
		return manufactureYear;
	}
	public void setManufactureYear(String manufactureYear) {
		if(manufactureYear=="")
			this.manufactureYear=null;
		else
			this.manufactureYear = manufactureYear;
		
	}
	public String getRegisteredYear() {
		return registeredYear;
	}
	public void setRegisteredYear(String registeredYear) {
		if(registeredYear=="")
			this.registeredYear = null;
		else
			this.registeredYear = registeredYear;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		if(chassisNo=="")
			this.chassisNo = null;
		else
			this.chassisNo = chassisNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		if(engineNo=="")
			this.engineNo = null;
		else
			this.engineNo = engineNo;
	}
	public String getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public FuelType getFtype() {
		return ftype;
	}
	public void setFtype(FuelType ftype) {
		this.ftype = ftype;
	}
	public String getNoWheel() {
		return noWheel;
	}
	public void setNoWheel(String noWheel) {
		this.noWheel = noWheel;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getEmissionNorms() {
		return emissionNorms;
	}
	public void setEmissionNorms(String emissionNorms) {
		this.emissionNorms = emissionNorms;
	}
	public String getCustomer_owner_status() {
		return customer_owner_status;
	}
	public void setCustomer_owner_status(String customer_owner_status) {
		this.customer_owner_status = customer_owner_status;
	}
	public String getCusTitle() {
		return cusTitle;
	}
	public void setCusTitle(String cusTitle) {
		this.cusTitle = cusTitle;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public CountryState getStateid() {
		return stateid;
	}
	public void setStateid(CountryState stateid) {
		this.stateid = stateid;
	}
	public TestCategory getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(TestCategory categoryId) {
		this.categoryId = categoryId;
	}
	
}
