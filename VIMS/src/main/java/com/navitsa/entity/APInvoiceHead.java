package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ap_invoice_head")
public class APInvoiceHead {

	@Id
	@Column(name = "ap_invoice_head_id")
	private String apInvoiceHeadId;

	@Column(name = "supplier_id")
	String supplierId;

	@Column(name = "supplier_gl_code")
	String supplierGlCode;

	@Column(name = "date")
	String date;

	@Column(name = "net_total")
	String netTotal;

	public APInvoiceHead() {

	}

	public APInvoiceHead(String apInvoiceHeadId, String supplierId, String supplierGlCode, String date,
			String netTotal) {
		this.apInvoiceHeadId = apInvoiceHeadId;
		this.supplierId = supplierId;
		this.supplierGlCode = supplierGlCode;
		this.date = date;
		this.netTotal = netTotal;
	}

	public String getApInvoiceHeadId() {
		return apInvoiceHeadId;
	}

	public void setApInvoiceHeadId(String apInvoiceHeadId) {
		this.apInvoiceHeadId = apInvoiceHeadId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierGlCode() {
		return supplierGlCode;
	}

	public void setSupplierGlCode(String supplierGlCode) {
		this.supplierGlCode = supplierGlCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(String netTotal) {
		this.netTotal = netTotal;
	}

	@Override
	public String toString() {
		return "APInvoiceHead [apInvoiceHeadId=" + apInvoiceHeadId + ", supplierId=" + supplierId + ", supplierGlCode="
				+ supplierGlCode + ", date=" + date + ", netTotal=" + netTotal + "]";
	}
}
