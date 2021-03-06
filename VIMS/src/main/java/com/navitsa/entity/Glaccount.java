package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "glaccount")
public class Glaccount {

	@Id
	@Column(name = "GlAccNo")
	private String glAccNo;
	
	@Column(name = "GlAccountName")
	private String glAccountName;
	

	@Column(name = "parentsAccount")
	private String parentsAccount;
	
	@Column(name = "PrimaryAccount")
	private String primaryAccount;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "Partner_ID", referencedColumnName = "Partner_ID")
	private BusinessPartner partnerID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name ="Center_ID" , referencedColumnName="Center_ID")
	private CenterMaster centerID;
	
	@Column(name = "Status")
	private String status;

	public Glaccount() {
	
	}

	public Glaccount(String glAccNo) {
		this.glAccNo = glAccNo;
	}

	public String getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(String glAccNo) {
		this.glAccNo = glAccNo;
	}

	public String getGlAccountName() {
		return glAccountName;
	}

	public void setGlAccountName(String glAccountName) {
		this.glAccountName = glAccountName;
	}


	public String getPrimaryAccount() {
		return primaryAccount;
	}

	public void setPrimaryAccount(String primaryAccount) {
		this.primaryAccount = primaryAccount;
	}

	public BusinessPartner getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(BusinessPartner partnerID) {
		this.partnerID = partnerID;
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

	public String getParentsAccount() {
		return parentsAccount;
	}

	public void setParentsAccount(String parentsAccount) {
		this.parentsAccount = parentsAccount;
	}


	
	
	
	
}


