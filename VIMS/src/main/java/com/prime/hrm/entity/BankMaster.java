package com.prime.hrm.entity;

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
@Table(name="bank_master")
public class BankMaster {
	
	@Id
	@NotEmpty(message="Please enter Bank code")
	@Column(name="Bank_ID")
	private String bankid;
	
	@NotEmpty(message="Please enter Bank Name")
	@Column(name="Bank_Name")
	private String bankName;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="Company_ID", referencedColumnName="Partner_ID")
	private BusinessPartner company;

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BusinessPartner getCompany() {
		return company;
	}

	public void setCompany(BusinessPartner company) {
		this.company = company;
	}
	
	public BankMaster(String bankid, String bankName,BusinessPartner company) {
		this.bankid = bankid;
		this.bankName = bankName;
		this.company = company;
	}

	public BankMaster() {
	
	}
	
	
	
}
