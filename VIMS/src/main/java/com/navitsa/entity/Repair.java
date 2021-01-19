package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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


}
