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
@Table(name="invoicedetails")
public class InvoiceDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="invoiceDetailId")	
	int invoiceDetailId;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "invoiceNo", referencedColumnName = "invoiceNo")
	InvoiceHead invoiceNo;	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "taxCode", referencedColumnName = "taxCode")
	TaxConfiguration taxCode;	
	@Column(name = "taxRate")
	Long taxRate;
	@Column(name = "taxAmount")
	Long taxAmount;
	public int getInvoiceDetailId() {
		return invoiceDetailId;
	}
	public void setInvoiceDetailId(int invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}
	public InvoiceHead getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(InvoiceHead invoiceNo) {
		this.invoiceNo = invoiceNo;
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

	public InvoiceDetails() {
		
	}
	public InvoiceDetails(InvoiceHead invoiceNo, TaxConfiguration taxCode, Long taxRate,Long taxAmount) {
		this.invoiceNo = invoiceNo;
		this.taxCode = taxCode;
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
	}
	
	
}
