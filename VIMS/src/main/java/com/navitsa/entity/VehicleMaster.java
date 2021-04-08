package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehicle_master")
public class VehicleMaster {

	@Id
	@NotEmpty(message = "required")
	@Pattern(regexp="^([a-zA-Z0-9_-]+$)?",message="Special Characters Not Allowed")
	@Column(name = "Vehicle_ID")
	private String vehicleID;

	//@NotEmpty(message = "required")
	@Pattern(regexp="^([a-zA-Z0-9_-]+$)?",message="Special Characters Not Allowed")
	@Column(name = "Engine_No")
	private String engineNo;

	//@NotEmpty(message = "required")
	@Pattern(regexp="^([a-zA-Z0-9_-]+$)?",message="Special Characters Not Allowed")
	@Column(name = "Chassis_No")
	private String chassisNo;

	//@NotEmpty(message = "required")
	//@Pattern(regexp="^([0-9]+$)?",message="Please Enter valid year")
	@Size(max = 12,message = "Please Enter valid year")
	@Column(name = "Manufacture_Year")
	private String manufactureYear;

	//@NotEmpty(message = "required")
	//@Pattern(regexp="^([0-9]+$)?",message="Please Enter valid year")
	@Size(max = 10,message = "Please Enter valid year")
	@Column(name = "Registered_Year")
	private String registeredYear;

	//@NotEmpty(message = "required")
	@Pattern(regexp="^([a-zA-Z0-9_-]+$)?",message="Special Characters Not Allowed")
	@Column(name = "Engine_Capacity")
	private String engineCapacity;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_Model_ID",referencedColumnName = "Vehicle_Model_ID")
	private VehicleModel vmodel;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Fuel_Type_ID",referencedColumnName = "Fuel_Type_ID")
	private FuelType ftype;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "subCategoryID",referencedColumnName = "subCategoryID")
	private VehiclesSubCategory subCategoryID;
	
	
	@Column(name = "noWheel")
	private String noWheel;
	
	@Column(name = "emissionNorms")
	private String emissionNorms;

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public String getRegisteredYear() {
		return registeredYear;
	}

	public void setRegisteredYear(String registeredYear) {
		this.registeredYear = registeredYear;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public VehicleModel getVmodel() {
		return vmodel;
	}

	public void setVmodel(VehicleModel vmodel) {
		this.vmodel = vmodel;
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

	public String getEmissionNorms() {
		return emissionNorms;
	}

	public void setEmissionNorms(String emissionNorms) {
		this.emissionNorms = emissionNorms;
	}

	public VehicleMaster() {
	}

	public VehicleMaster(String vehicleID, String engineNo, String chassisNo, String manufactureYear,
			String registeredYear, String engineCapacity, VehicleModel vmodel, FuelType ftype, String noWheel,
			String emissionNorms) {
		super();
		this.vehicleID = vehicleID;
		this.engineNo = engineNo;
		this.chassisNo = chassisNo;
		this.manufactureYear = manufactureYear;
		this.registeredYear = registeredYear;
		this.engineCapacity = engineCapacity;
		this.vmodel = vmodel;
		this.ftype = ftype;
		this.noWheel = noWheel;
		this.emissionNorms = emissionNorms;
	}

	public VehicleMaster(String vehicleNo) {
		this.vehicleID = vehicleNo;
	}

	public VehiclesSubCategory getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(VehiclesSubCategory subCategoryID) {
		this.subCategoryID = subCategoryID;
	}
	
}