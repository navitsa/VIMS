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
@Table(name = "issue_ticket")
public class IssueTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_No")
	int ticketNo;
	
	@Column(name = "issue")
	private String issue;
	
	@Column(name = "issue_type")
	private String issueType;
	
	@Column(name = "issue_Date")
	private String issueDate;
	
	@Column(name="issue_time")
	private String issueTime;
	
	@Column(name = "Issue_Status")
	private String issueStatus;
	
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "testLaneHead_Id", referencedColumnName = "testLaneHead_Id")
	private TestLaneHead testLaneHeadId;
	
	@Column(name="LaneStatus")
	private String laneStatus;
	
	@Column(name="lane_issue_time")
	private String laneIssueTime;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "Equipment_ID", referencedColumnName = "Equipment_ID")
	private EquipmentMaster equipmentID;
	
	@Column(name = "Eq_Is_working")
	private String eqIsWorking;
		
	@Column(name="Eq_issue_time")
	private String equipmentIssueTime;
	
	
	
	@Column(name = "Status")
	private String status;



	public int getTicketNo() {
		return ticketNo;
	}



	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}



	public String getIssue() {
		return issue;
	}



	public void setIssue(String issue) {
		this.issue = issue;
	}



	public String getIssueType() {
		return issueType;
	}



	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}



	public String getIssueDate() {
		return issueDate;
	}



	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}



	public String getIssueTime() {
		return issueTime;
	}



	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}



	public String getIssueStatus() {
		return issueStatus;
	}



	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}



	public TestLaneHead getTestLaneHeadId() {
		return testLaneHeadId;
	}



	public void setTestLaneHeadId(TestLaneHead testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}



	public String getLaneStatus() {
		return laneStatus;
	}



	public void setLaneStatus(String laneStatus) {
		this.laneStatus = laneStatus;
	}



	public String getLaneIssueTime() {
		return laneIssueTime;
	}



	public void setLaneIssueTime(String laneIssueTime) {
		this.laneIssueTime = laneIssueTime;
	}



	public EquipmentMaster getEquipmentID() {
		return equipmentID;
	}



	public void setEquipmentID(EquipmentMaster equipmentID) {
		this.equipmentID = equipmentID;
	}



	public String getEqIsWorking() {
		return eqIsWorking;
	}



	public void setEqIsWorking(String eqIsWorking) {
		this.eqIsWorking = eqIsWorking;
	}



	public String getEquipmentIssueTime() {
		return equipmentIssueTime;
	}



	public void setEquipmentIssueTime(String equipmentIssueTime) {
		this.equipmentIssueTime = equipmentIssueTime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
