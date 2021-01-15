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
@Table(name = "ticketclose")
public class TicketClose {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ticket_Close_ID")
	int ticketCloseID;
		
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_No", referencedColumnName = "ticket_No")
	private IssueTicket ticketNo;
		
	@Column(name = "Remarks")
	private String remarks;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "supervis_userId", referencedColumnName = "userId")
	private Users userId;
		
	@Column(name = "closeDate")
	private String closeDate;
	
	@Column(name = "closeTime")
	private String closeTime;
		
	@Column(name = "Status")
	private String status;

	public int getTicketCloseID() {
		return ticketCloseID;
	}

	public void setTicketCloseID(int ticketCloseID) {
		this.ticketCloseID = ticketCloseID;
	}

	public IssueTicket getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(IssueTicket ticketNo) {
		this.ticketNo = ticketNo;
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

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
}
