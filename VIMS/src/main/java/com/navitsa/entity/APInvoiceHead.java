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

	@Column(name = "reference_no")
	String referenceNo;

	@Column(name = "date")
	String date;

	@Column(name = "gross_total")
	Long grossTotal;
	
	@Column(name = "discount_total")
	Long discountTotal;
	
	@Column(name = "tax_total")
	Long taxTotal;
	
	@Column(name = "net_total")
	Long netTotal;

	public APInvoiceHead() {

	}

	public APInvoiceHead(String apInvoiceHeadId, String supplierId, String referenceNo, String date, Long grossTotal,
			Long discountTotal, Long taxTotal, Long netTotal) {
		super();
		this.apInvoiceHeadId = apInvoiceHeadId;
		this.supplierId = supplierId;
		this.referenceNo = referenceNo;
		this.date = date;
		this.grossTotal = grossTotal;
		this.discountTotal = discountTotal;
		this.taxTotal = taxTotal;
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

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Long grossTotal) {
		this.grossTotal = grossTotal;
	}

	public Long getDiscountTotal() {
		return discountTotal;
	}

	public void setDiscountTotal(Long discountTotal) {
		this.discountTotal = discountTotal;
	}

	public Long getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(Long taxTotal) {
		this.taxTotal = taxTotal;
	}

	public Long getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(Long netTotal) {
		this.netTotal = netTotal;
	}

	@Override
	public String toString() {
		return "APInvoiceHead [apInvoiceHeadId=" + apInvoiceHeadId + ", supplierId=" + supplierId + ", referenceNo="
				+ referenceNo + ", date=" + date + ", grossTotal=" + grossTotal + ", discountTotal=" + discountTotal
				+ ", taxTotal=" + taxTotal + ", netTotal=" + netTotal + "]";
	}
}
