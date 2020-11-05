package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "vehicle_make")
public class VehicleMake {
	@Id
	@NotEmpty(message = "required")
	@Column(name = "Vehicle_Make_ID")
	private String vehicleMakeID;
	
	@NotEmpty(message = "Please enter a vehicle make")
	@Column(name = "Vehicle_Make")
	private String vehicleMake;
	
	@Column(name = "V_Make_Logo")
	private byte[] makeLogo;
	
	@Column(name = "Status")
	private String status;

	@Column(name="Remark")
	private String remark;

	public String getVehicleMakeID() {
		return vehicleMakeID;
	}
	public void setVehicleMakeID(String vehicleMakeID) {
		this.vehicleMakeID = vehicleMakeID;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getMakeLogoView() {
		return Base64.getEncoder().encodeToString(this.makeLogo);
	}
	public byte[] getMakeLogo() {
		return makeLogo;
	}

	public void setMakeLogo(MultipartFile makeLogo) throws IOException {

		if (makeLogo.isEmpty()) {
			this.makeLogo = null;
		} else {
			this.makeLogo = makeLogo.getBytes();
		}
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
	
	public VehicleMake(String vehicleMakeID, String vehicleMake, MultipartFile makeLogo, String status,String remark) throws IOException {
		this.vehicleMakeID = vehicleMakeID;
		this.vehicleMake = vehicleMake;
		this.makeLogo = makeLogo.getBytes();
		this.status = status;
		this.remark = remark;
	}
	public VehicleMake() {
	}
	public VehicleMake(String vehicleMakeID) {
		this.vehicleMakeID = vehicleMakeID;
	}
	public VehicleMake(String vehicleMakeID, String vehicleMake,String status,String remark)
	{
		this.vehicleMakeID = vehicleMakeID;
		this.vehicleMake = vehicleMake;
		this.status = status;
		this.remark = remark;
	}

}
