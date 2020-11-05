package com.navitsa.entity;

import java.io.IOException;
//import java.sql.Blob;
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
@Table(name = "vehicle_model")
public class VehicleModel {

	@Id
	@NotEmpty(message = "required")
	@Column(name = "Vehicle_Model_ID")
	private String vehicleModelID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_Make_ID" , referencedColumnName="Vehicle_Make_ID")
	private VehicleMake vehicleMakeID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_Class_ID" , referencedColumnName="Vehicle_Class_ID")
	private VehicleClass vehicleClass;
	
	@NotEmpty(message = "Please enter a model name")
	@Column(name = "Vehicle_Model")
	private String vehicleModel;
	
	@Column(name = "V_Model_Logo")
	private byte[] modelLogo;
	
	@Column(name = "Status")
	private String status;
	
	public String getVehicleModelID() {
		return vehicleModelID;
	}

	public void setVehicleModelID(String vehicleModelID) {
		this.vehicleModelID = vehicleModelID;
	}

	
	public VehicleMake getVehicleMakeID() {
		return vehicleMakeID;
	}

	public void setVehicleMakeID(VehicleMake vehicleMakeID) {
		this.vehicleMakeID = vehicleMakeID;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public byte[] getModelLogo() {
		return modelLogo;
	}
	
	public void setModelLogo(MultipartFile modelLogo) throws IOException {
		if(modelLogo.isEmpty()) {
			modelLogo = null;
		}
		else {
			this.modelLogo = modelLogo.getBytes();
		}
		
	}

	public String getModelLogoView() {
		return Base64.getEncoder().encodeToString(this.modelLogo);
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public VehicleModel(String vehicleModelID, VehicleMake vehicleMakeID, String vehicleModel,MultipartFile modelLogo,
			String status) throws IOException {
		
		this.vehicleModelID = vehicleModelID;
		this.vehicleMakeID = vehicleMakeID;
		this.vehicleModel = vehicleModel;
		this.modelLogo = modelLogo.getBytes();
		this.status = status;
	}

	public VehicleModel() {
		
	}

	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

}
