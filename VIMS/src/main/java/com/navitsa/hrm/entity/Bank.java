package com.navitsa.hrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.navitsa.entity.BusinessPartner;

@Entity
@Table(name="bank_branch")
public class Bank {
	
	@Id
	@Column(name="Branch_ID")
	private String branchID;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="Bank_ID", referencedColumnName ="Bank_ID")
	private BankMaster bankid;
	
	@NotEmpty(message="required")
	@Column(name="Branch")
	private String branch;
	
	@NotEmpty(message="required")
	@Column(name="Address")
	private String address;
	
	@NotEmpty(message="required")
	@Column(name="Contact_No")
	private String contactNo;
	


	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public BankMaster getBankid() {
		return bankid;
	}

	public void setBankid(BankMaster bankid) {
		this.bankid = bankid;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Bank() {
		
	}
	
	

}
