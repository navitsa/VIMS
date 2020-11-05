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
@Table(name = "equipment_make")
public class EquipmentMake {
	@Id
	@Column(name = "Eq_Make_ID")
	private String eqMakeID;

	@NotEmpty(message = "Please enter a make")
	@Column(name = "Eq_Make")
	private String eqMake;
	
	@Column(name = "Eq_Make_Logo")
	private byte[] eqMakeLogo;
		
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Remarks")
	private String remarks;

	public EquipmentMake() {
	}

	public EquipmentMake(String eqMakeID, String eqMake,MultipartFile  eqMakeLogo, String status, String remarks) throws IOException {
		this.eqMakeID = eqMakeID;
		this.eqMake = eqMake;
		this.eqMakeLogo = eqMakeLogo.getBytes();
		this.status = status;
		this.remarks = remarks;
	}
	
	

	public EquipmentMake(String eqMakeID, String eqMake, String status, String remarks) {
		
		this.eqMakeID = eqMakeID;
		this.eqMake = eqMake;
		this.status = status;
		this.remarks = remarks;
	}

	public EquipmentMake(String eqMakeID) {
		this.eqMakeID = eqMakeID;
	}

	public String getEqMakeID() {
		return eqMakeID;
	}

	public void setEqMakeID(String eqMakeID) {
		this.eqMakeID = eqMakeID;
	}

	public String getEqMake() {
		return eqMake;
	}

	public void setEqMake(String eqMake) {
		this.eqMake = eqMake;
	}

	public byte[] getEqMakeLogo() {
		return eqMakeLogo;
	}

	public void setEqMakeLogo(MultipartFile eqMakeLogo) throws IOException {
		if(eqMakeLogo.isEmpty())
		{
			this.eqMakeLogo = null;
		}
		else {
			this.eqMakeLogo = eqMakeLogo.getBytes();
			}
		
		
	}

	public String getEqMakeLogoView() {
		return Base64.getEncoder().encodeToString(this.eqMakeLogo);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
