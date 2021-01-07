package com.navitsa.entity;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name = "equipmentscalibration")
public class EquipmentsCalibration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eCalID")
	int eCalID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Equipment_ID", referencedColumnName = "Equipment_ID")
	private EquipmentMaster equipmentID;
	
	@Column(name = "Last_Calibration_Date")
	private String lastCalibrationDate;

	@Column(name = "Calibration_Date")
	private String calibrationDate;
	
	@Column(name = "Calibrated_Date")
	private String calibratedDate;
		
	@Column(name = "Next_Calibrated_Date")
	private String nextCalibratedDate;
		
	@Column(name = "Calibration_Report")
	private byte[] calibrationReport;
	
	@Column(name = "Calibration_Status")
	private String calibrationStatus;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Calibration_UserID", referencedColumnName = "userId")
	private Users userId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Center_ID", referencedColumnName = "Center_ID")
	private CenterMaster centerID;
	
	@Column(name = "TranctionDate")
	private String tranctionDate;
		
	@Column(name = "TranctionUser")
	private String tranctionUser;
	
	
	public String getTranctionDate() {
		return tranctionDate;
	}

	public void setTranctionDate(String tranctionDate) {
		this.tranctionDate = tranctionDate;
	}

	public String getTranctionUser() {
		return tranctionUser;
	}

	public void setTranctionUser(String tranctionUser) {
		this.tranctionUser = tranctionUser;
	}

	@Column(name = "Status")
	private String status;

	public int geteCalID() {
		return eCalID;
	}

	public void seteCalID(int eCalID) {
		this.eCalID = eCalID;
	}

	public EquipmentMaster getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(EquipmentMaster equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getLastCalibrationDate() {
		return lastCalibrationDate;
	}

	public void setLastCalibrationDate(String lastCalibrationDate) {
		this.lastCalibrationDate = lastCalibrationDate;
	}

	public String getCalibrationDate() {
		return calibrationDate;
	}

	public void setCalibrationDate(String calibrationDate) {
		this.calibrationDate = calibrationDate;
	}

	public byte[] getCalibrationReport() {
		return calibrationReport;
	}

	public void setCalibrationReport(MultipartFile calibrationReport) throws IOException {
		if(calibrationReport.isEmpty()) {
			calibrationReport = null;
		} else {
		this.calibrationReport = calibrationReport.getBytes();
		}
		
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public CenterMaster getCenterID() {
		return centerID;
	}

	public void setCenterID(CenterMaster centerID) {
		this.centerID = centerID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCalibrationStatus() {
		return calibrationStatus;
	}

	public void setCalibrationStatus(String calibrationStatus) {
		this.calibrationStatus = calibrationStatus;
	}

	public String getCalibratedDate() {
		return calibratedDate;
	}

	public void setCalibratedDate(String calibratedDate) {
		this.calibratedDate = calibratedDate;
	}

	public String getNextCalibratedDate() {
		return nextCalibratedDate;
	}

	public void setNextCalibratedDate(String nextCalibratedDate) {
		this.nextCalibratedDate = nextCalibratedDate;
	}
	
	
}
