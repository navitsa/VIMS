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
@Table(name = "repair")
public class Repair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRepair")
	int idRepair;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_No", referencedColumnName = "ticket_No")
	private IssueTicket ticketNo;

	@Column(name = "jobNo")
	private String jobNo;
	
	@Column(name = "Repair_Date")
	private String repairDate;
	
	@Column(name = "Maintenance_Cost")
	private Double maintenanceCost;
	
	@Column(name = "Labo_Cost")
	private Double laboCost;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "calibrationPre")
	private String calibrationPre;
	
	@Column(name = "calibrationStatus")
	private String calibrationStatus;
	
	@Column(name = "calibrationReport")
	private byte[] calibrationReport;
	
	public int getIdRepair() {
		return idRepair;
	}

	public void setIdRepair(int idRepair) {
		this.idRepair = idRepair;
	}

	public IssueTicket getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(IssueTicket ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	public Double getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(Double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public Double getLaboCost() {
		return laboCost;
	}

	public void setLaboCost(Double laboCost) {
		this.laboCost = laboCost;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCalibrationPre() {
		return calibrationPre;
	}

	public void setCalibrationPre(String calibrationPre) {
		this.calibrationPre = calibrationPre;
	}

	public String getCalibrationStatus() {
		return calibrationStatus;
	}

	public void setCalibrationStatus(String calibrationStatus) {
		this.calibrationStatus = calibrationStatus;
	}

	public byte[] getCalibrationReport() {
		return calibrationReport;
	}

	public void setCalibrationReport(MultipartFile calibrationrpt) throws IOException {
		
		if(calibrationrpt.isEmpty()) {
			this.calibrationReport = null;
		} else {
			this.calibrationReport = calibrationrpt.getBytes();
		}
	}


}
