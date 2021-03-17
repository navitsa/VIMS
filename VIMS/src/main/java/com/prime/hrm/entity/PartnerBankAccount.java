package com.prime.hrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.navitsa.entity.Glaccount;

@Entity
@Table(name="partner_bank_account")
public class PartnerBankAccount {

	@Id
	@Column(name="BankAccountNo")
	private String bankAccountNo;
	
	@Column(name="AccountName")
	private String accountName;
		
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="Branch_ID", referencedColumnName ="Branch_ID")
	private Bank branchID;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="GlAccNo", referencedColumnName ="GlAccNo")
	private Glaccount glAccNo;

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Bank getBranchID() {
		return branchID;
	}

	public void setBranchID(Bank branchID) {
		this.branchID = branchID;
	}

	public Glaccount getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(Glaccount glAccNo) {
		this.glAccNo = glAccNo;
	}
	
	
}
