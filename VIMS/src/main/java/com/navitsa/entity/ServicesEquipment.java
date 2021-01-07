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
@Table(name = "equipmentsservices")
public class ServicesEquipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eSalID")
	int eSalID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Equipment_ID", referencedColumnName = "Equipment_ID")
	private EquipmentMaster equipmentID;
	
	@Column(name = "Last_Services_Date")
	private String lastServicesDate;

	@Column(name = "Services_Date")
	private String servicesDate;
	
	@Column(name = "Serviced_Date")
	private String servicedDate;
		
	@Column(name = "Next_Services_Date")
	private String nextServicesDate;
		
	@Column(name = "Services_Report")
	private byte[] servicesReport;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Services_UserID", referencedColumnName = "userId")
	private Users userId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Center_ID", referencedColumnName = "Center_ID")
	private CenterMaster centerID;
	
	@Column(name = "TranctionDate")
	private String tranctionDate;
		
	@Column(name = "TranctionUser")
	private String tranctionUser;
	
	@Column(name = "Status")
	private String status;

	public int geteSalID() {
		return eSalID;
	}

	public void seteSalID(int eSalID) {
		this.eSalID = eSalID;
	}

	public EquipmentMaster getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(EquipmentMaster equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getLastServicesDate() {
		return lastServicesDate;
	}

	public void setLastServicesDate(String lastServicesDate) {
		this.lastServicesDate = lastServicesDate;
	}

	public String getServicesDate() {
		return servicesDate;
	}

	public void setServicesDate(String servicesDate) {
		this.servicesDate = servicesDate;
	}

	public String getServicedDate() {
		return servicedDate;
	}

	public void setServicedDate(String servicedDate) {
		this.servicedDate = servicedDate;
	}

	public String getNextServicesDate() {
		return nextServicesDate;
	}

	public void setNextServicesDate(String nextServicesDate) {
		this.nextServicesDate = nextServicesDate;
	}

	public byte[] getServicesReport() {
		return servicesReport;
	}

	public void setServicesReport(MultipartFile servicesReport) throws IOException {
		if(servicesReport.isEmpty()) {
			servicesReport = null;
		} else {
		this.servicesReport = servicesReport.getBytes();
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
