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
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "equipment_model")
public class EquipmentModel {

	@Id
	@Column(name = "Eq_Model_ID")
	private String eqModelID;
	
	@NotEmpty(message = "Please enter a equipment model")
	@Column(name = "Eq_Model")
	private String eqModel;
	
	@Column(name = "Eq_Model_Logo")
	private byte[] eqModelLogo;
	
	@Column(name="Eq_Model_Ma")
	private byte[] eqModelMa;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@NotEmpty(message = "Please enter the calibration inverval")
	@Pattern(regexp="^([0-9]+$)?",message="Please enter the calibration interval in months")
	@Column(name = "Calibration_Interval")
	private String calibrationInt;
	
	@NotEmpty(message = "Please enter the service inverval")
	@Pattern(regexp="^([0-9]+$)?",message="Please enter the service interval in months")
	@Column(name = "Service_Interval")
	private String serviceInt;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Eq_Make_ID", referencedColumnName = "Eq_Make_ID")
	private EquipmentMake eqMakeID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Eq_Type_ID", referencedColumnName = "Eq_Type_ID")
	private EquipmentType eqTypeID;

	public EquipmentModel() {
	}

	public EquipmentModel(String eqModelID) {
		this.eqModelID = eqModelID;
	}

	public String getEqModelID() {
		return eqModelID;
	}

	public void setEqModelID(String eqModelID) {
		this.eqModelID = eqModelID;
	}

	public String getEqModel() {
		return eqModel;
	}

	public void setEqModel(String eqModel) {
		this.eqModel = eqModel;
	}
	
	public String getCalibrationInt() {
		return calibrationInt;
	}

	public void setCalibrationInt(String calibrationInt) {
		this.calibrationInt = calibrationInt;
	}

	public String getServiceInt() {
		return serviceInt;
	}

	public void setServiceInt(String serviceInt) {
		this.serviceInt = serviceInt;
	}

	public byte[] getEqModelMa() {
		return eqModelMa;
	}

	public void setEqModelMa(MultipartFile eqModelMa) throws IOException {
		if(eqModelMa.isEmpty()) {
			eqModelMa = null;
		} else {
		this.eqModelMa = eqModelMa.getBytes();
		}
	}

	public EquipmentType getEqTypeID() {
		return eqTypeID;
	}

	public void setEqTypeID(EquipmentType eqTypeID) {
		this.eqTypeID = eqTypeID;
	}
	public byte[] getEqModelLogo() {
		return eqModelLogo;
	}
	public void setEqModelLogo(MultipartFile eqModelLogo) throws IOException {
		if(eqModelLogo.isEmpty()) {
			eqModelLogo = null;
		}else {
			this.eqModelLogo = eqModelLogo.getBytes();
		}	
	}
	public String getEqModelLogoView() {
		return Base64.getEncoder().encodeToString(this.eqModelLogo);
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

	public EquipmentMake getEqMakeID() {
		return eqMakeID;
	}

	public void setEqMakeID(EquipmentMake eqMakeID) {
		this.eqMakeID = eqMakeID;
	}

	public EquipmentModel(String eqModelID, String eqModel, MultipartFile eqModelLogo, String status, String remarks,
			String calibrationInt,String serviceInt,EquipmentMake eqMakeID,MultipartFile eqModelMa,
			EquipmentType eqTypeID) throws IOException {
		this.eqModelID = eqModelID;
		this.eqModel = eqModel;
		this.eqModelLogo = eqModelLogo.getBytes();
		this.status = status;
		this.remarks = remarks;
		this.eqMakeID = eqMakeID;
		this.calibrationInt = calibrationInt;
		this.serviceInt = serviceInt;
		this.eqModelMa = eqModelMa.getBytes();
		this.eqTypeID = eqTypeID;
	}


}
