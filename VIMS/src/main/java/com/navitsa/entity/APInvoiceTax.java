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
@Table(name = "ap_invoice_tax")
public class APInvoiceTax {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ap_invoice_tax_id")
	private int apInvoiceTaxId;

	@Column(name = "tax_code")
	String taxCode;

	@Column(name = "total")
	Long total;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ap_invoice_head_id", referencedColumnName = "ap_invoice_head_id")
	private APInvoiceHead apInvoiceHeadId;

	public APInvoiceTax() {

	}

	public APInvoiceTax(int apInvoiceTaxId, String taxCode, Long total, APInvoiceHead apInvoiceHeadId) {
		super();
		this.apInvoiceTaxId = apInvoiceTaxId;
		this.taxCode = taxCode;
		this.total = total;
		this.apInvoiceHeadId = apInvoiceHeadId;
	}

	public int getApInvoiceTaxId() {
		return apInvoiceTaxId;
	}

	public void setApInvoiceTaxId(int apInvoiceTaxId) {
		this.apInvoiceTaxId = apInvoiceTaxId;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public APInvoiceHead getApInvoiceHeadId() {
		return apInvoiceHeadId;
	}

	public void setApInvoiceHeadId(APInvoiceHead apInvoiceHeadId) {
		this.apInvoiceHeadId = apInvoiceHeadId;
	}

	@Override
	public String toString() {
		return "APInvoiceTax [apInvoiceTaxId=" + apInvoiceTaxId + ", taxCode=" + taxCode + ", total=" + total
				+ ", apInvoiceHeadId=" + apInvoiceHeadId + "]";
	}
}
