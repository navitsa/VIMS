package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ap_invoice_head")
public class APInvoiceHead {

	@Id
	@Column(name = "ap_invoice_head_id")
	private String apInvoiceHeadId;

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

	@Column(name = "balance")
	Long balance;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
	private SupplierMaster supplierMaster;

	public APInvoiceHead() {

	}

	public APInvoiceHead(String apInvoiceHeadId, String referenceNo, String date, Long grossTotal, Long discountTotal,
			Long taxTotal, Long netTotal, Long balance, SupplierMaster supplierMaster) {
		super();
		this.apInvoiceHeadId = apInvoiceHeadId;
		this.referenceNo = referenceNo;
		this.date = date;
		this.grossTotal = grossTotal;
		this.discountTotal = discountTotal;
		this.taxTotal = taxTotal;
		this.netTotal = netTotal;
		this.balance = balance;
		this.supplierMaster = supplierMaster;
	}

	public String getApInvoiceHeadId() {
		return apInvoiceHeadId;
	}

	public void setApInvoiceHeadId(String apInvoiceHeadId) {
		this.apInvoiceHeadId = apInvoiceHeadId;
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

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public SupplierMaster getSupplierMaster() {
		return supplierMaster;
	}

	public void setSupplierMaster(SupplierMaster supplierMaster) {
		this.supplierMaster = supplierMaster;
	}

	@Override
	public String toString() {
		return "APInvoiceHead [apInvoiceHeadId=" + apInvoiceHeadId + ", referenceNo=" + referenceNo + ", date=" + date
				+ ", grossTotal=" + grossTotal + ", discountTotal=" + discountTotal + ", taxTotal=" + taxTotal
				+ ", netTotal=" + netTotal + ", balance=" + balance + ", supplierMaster=" + supplierMaster + "]";
	}
}
