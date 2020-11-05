package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "vehicle_class")
public class VehicleClass {
	
	@Id
	@Column(name = "Vehicle_Class_ID")
	String vehicleClassID;
	
	@NotEmpty(message = "Please enter a vehicle class name")
	@Column(name = "Vehicle_Class")
	String vehicleClass;
	
	@Column(name="Remarks")
	String remark;
	
	@Column(name="Status")
	String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryID" , referencedColumnName="categoryID")
	private VehicleCategory categoryID;

	@Column(name = "vehicle_class_Logo")
	byte[] vehicleclassLogo;
	
	public String getVehicleClassID() {
		return vehicleClassID;
	}

	public void setVehicleClassID(String vehicleClassID) {
		this.vehicleClassID = vehicleClassID;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getVehicleclassLogo() {
		return vehicleclassLogo;
	}

	public void setVehicleclassLogo(MultipartFile vehicleclassLogo) throws IOException {
		
		if(vehicleclassLogo.isEmpty())
		{
			this.vehicleclassLogo = null;
		}
		else {
			this.vehicleclassLogo = vehicleclassLogo.getBytes();
		}
	}
	
	public String getVehicleclassLogoView() {
		return Base64.getEncoder().encodeToString(this.vehicleclassLogo);
	}

	public VehicleCategory getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(VehicleCategory categoryID) {
		this.categoryID = categoryID;
	}

	public VehicleClass() {
		
	}

	public VehicleClass(String vehicleClassID, String vehicleClass, String remark, String status, MultipartFile vehicleclassLogo,VehicleCategory categoryID) throws IOException {
		this.vehicleClassID = vehicleClassID;
		this.vehicleClass = vehicleClass;
		this.remark = remark;
		this.status = status;
		this.vehicleclassLogo = vehicleclassLogo.getBytes();
		this.categoryID=categoryID;
	}
	public VehicleClass(String vehicleClassID, String vehicleClass, String remark, String status,VehicleCategory categoryID) {
		this.vehicleClassID = vehicleClassID;
		this.vehicleClass = vehicleClass;
		this.remark = remark;
		this.status = status;
		this.categoryID=categoryID;
	}

}
