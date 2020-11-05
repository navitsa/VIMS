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
@Table(name = "equipment_master")
public class EquipmentMaster {
	@Id
	@Column(name = "Equipment_ID")
	private String equipmentID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Eq_Model_ID", referencedColumnName = "Eq_Model_ID")
	private EquipmentModel eqModelID;
	
	@NotEmpty(message = "Please enter a serial number")
	@Column(name = "Serial_No")
	private String serialNo;
	
	@Column(name = "Equipment_Image")
	private byte[] equipmentImage;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Remarks")
	private String remarks;

	@Column(name="Last_Calibration_Date")
	private String lastCalibrationDate;
	
	@Column(name="Last_Service_Date")
	private String lastServiceDate;
	
	@Column(name="Next_Calibration_Date")
	private String nextCalibrationDate;
	
	@Column(name="Next_Service_Date")
	private String nextServiceDate;
	
	@Column(name="Last_Calibration_Certificate")
	private byte[] lastCalibrationCer;
	
	@Column(name="Last_Service_Certificate")
	private byte[] lastServiceCer;
	
	@Column(name="Last_Calibration_Report")
	private byte[] lastCalibrationReport;
	
	@Column(name="Last_Service_Report")
	private byte[] lastServiceReport;
	
	@Column(name="Install_Date")
	private String installDate;
	
	@Column(name="Comm_Date")
	private String commDate;
	
	@Column(name="Train_Date")
	private String trainDate;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "invLoID", referencedColumnName = "invLoID")
	private InventoryLocation invLoID;
	
	
	public EquipmentMaster() {

	}
	
	public EquipmentMaster(String equipmentID) {
		
		this.equipmentID = equipmentID;
	}

	public EquipmentMaster(String equipmentID, EquipmentModel eqModelID, String serialNo,
			MultipartFile equipmentImage, String status, String remarks,
			String lastCalibrationDate,String lastServiceDate,String nextCalibrationDate,
			String nextServiceDate,MultipartFile lastCalibrationCer,MultipartFile lastServiceCer,
			MultipartFile lastCalibrationReport,MultipartFile lastServiceReport) throws IOException {
		this.equipmentID = equipmentID;
		this.eqModelID = eqModelID;
		this.serialNo = serialNo;
		this.equipmentImage = equipmentImage.getBytes();
		this.status = status;
		this.remarks = remarks;
		this.lastCalibrationDate = lastCalibrationDate;
		this.lastServiceDate = lastServiceDate;
		this.nextCalibrationDate = nextCalibrationDate;
		this.nextServiceDate = nextServiceDate;
		this.lastCalibrationCer = lastCalibrationCer.getBytes();
		this.lastServiceCer = lastServiceCer.getBytes();
		this.lastCalibrationReport = lastCalibrationReport.getBytes();
		this.lastServiceReport = lastServiceReport.getBytes();
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	
	public EquipmentModel getEqModelID() {
		return eqModelID;
	}

	public void setEqModelID(EquipmentModel eqModelID) {
		this.eqModelID = eqModelID;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public byte[] getEquipmentImage() {
		return equipmentImage;
	}

	public void setEquipmentImage(MultipartFile equipmentImage) throws IOException {
		if(equipmentImage.isEmpty()) {
			equipmentImage = null;
		}
		else {
			this.equipmentImage = equipmentImage.getBytes();
		}
	}

	public String getEquipmentImageView() {
		return Base64.getEncoder().encodeToString(this.equipmentImage);
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

	public String getLastCalibrationDate() {
		return lastCalibrationDate;
	}

	public void setLastCalibrationDate(String lastCalibrationDate) {
		this.lastCalibrationDate = lastCalibrationDate;
	}

	public String getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	
	public String getNextCalibrationDate() {
		return nextCalibrationDate;
	}

	public void setNextCalibrationDate(String nextCalibrationDate) {
		this.nextCalibrationDate = nextCalibrationDate;
	}

	public String getNextServiceDate() {
		return nextServiceDate;
	}

	public void setNextServiceDate(String nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}

	public byte[] getLastCalibrationCer() {
		return lastCalibrationCer;
	}

	public void setLastCalibrationCer(MultipartFile lastCalibrationCer) throws IOException {
		if(lastCalibrationCer.isEmpty()) {
			lastCalibrationCer = null;
		} else {
		this.lastCalibrationCer = lastCalibrationCer.getBytes();
		}
	}

	public String getLastCalibrationCerView() {
		return Base64.getEncoder().encodeToString(this.lastCalibrationCer);
	}
	
	public byte[] getLastServiceCer() {
		return lastServiceCer;
	}

	public void setLastServiceCer(MultipartFile lastServiceCer) throws IOException {
		if(lastServiceCer.isEmpty()) {
			lastServiceCer = null;
		} else {
		this.lastServiceCer = lastServiceCer.getBytes();
		}
	}
	
	public String getLastServieCerView() {
		return Base64.getEncoder().encodeToString(this.getLastServiceCer());
	}

	public byte[] getLastCalibrationReport() {
		return lastCalibrationReport;
	}

	public void setLastCalibrationReport(MultipartFile lastCalibrationReport) throws IOException {
		if(lastCalibrationReport.isEmpty()) {
			lastCalibrationReport = null;
		} else {
		this.lastCalibrationReport = lastCalibrationReport.getBytes();
		}
	}
	

	public String getLastCalibrationReportView() {
		return Base64.getEncoder().encodeToString(this.lastCalibrationReport);
	}
	
	public byte[] getLastServiceReport() {
		return lastServiceReport;
	}

	public void setLastServiceReport(MultipartFile lastServiceReport) throws IOException {
		if(lastServiceReport.isEmpty()) {
			lastServiceReport = null;
		} else {
		this.lastServiceReport = lastServiceReport.getBytes();
		}
	}

	public String getLastServieReportView() {
		return Base64.getEncoder().encodeToString(this.lastServiceReport);
	}

	public String getInstallDate() {
		return installDate;
	}

	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}

	public String getCommDate() {
		return commDate;
	}

	public void setCommDate(String commDate) {
		this.commDate = commDate;
	}

	public String getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(String trainDate) {
		this.trainDate = trainDate;
	}

	public InventoryLocation getInvLoID() {
		return invLoID;
	}

	public void setInvLoID(InventoryLocation invLoID) {
		this.invLoID = invLoID;
	}
	
}
