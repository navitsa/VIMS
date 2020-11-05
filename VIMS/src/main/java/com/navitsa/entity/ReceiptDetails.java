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
@Table(name="receiptdetails")
public class ReceiptDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="recDetailId")	
	int recDetailId;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "recNo", referencedColumnName = "recNo")
	ReceiptHead recNo;	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "taxCode", referencedColumnName = "taxCode")
	TaxConfiguration taxCode;	
	@Column(name = "taxRate")
	Long taxRate;
	@Column(name = "taxAmount")
	Long taxAmount;
	
	public int getRecDetailId() {
		return recDetailId;
	}
	public void setRecDetailId(int recDetailId) {
		this.recDetailId = recDetailId;
	}
	public ReceiptHead getRecNo() {
		return recNo;
	}
	public void setRecNo(ReceiptHead recNo) {
		this.recNo = recNo;
	}
	public TaxConfiguration getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(TaxConfiguration taxCode) {
		this.taxCode = taxCode;
	}
	public Long getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}
	public Long getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Long taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public ReceiptDetails() {
	}
	public ReceiptDetails(ReceiptHead recNo, TaxConfiguration taxCode, Long taxRate, Long taxAmount) {
		
		this.recNo = recNo;
		this.taxCode = taxCode;
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
	}
	
}
