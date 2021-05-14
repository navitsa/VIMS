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
@Table(name = "ap_invoice_payment_details")
public class APInvoicePaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ap_payment_details_id")
	private int apInvoicePaymentDetailsId;

	@Column(name = "reference_no")
	String referenceNo;

	@Column(name = "invoice_total")
	Long invoiceTotal;

	@Column(name = "invoice_payment")
	Long invoicePayment;

	@Column(name = "invoice_balance")
	Long invoiceBalance;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ap_payment_head_id", referencedColumnName = "ap_payment_head_id")
	private APInvoicePaymentHead apInvoicePaymentHeadId;

	public APInvoicePaymentDetails() {

	}

	public APInvoicePaymentDetails(int apInvoicePaymentDetailsId, String referenceNo, Long invoiceTotal,
			Long invoicePayment, Long invoiceBalance, APInvoicePaymentHead apInvoicePaymentHeadId) {
		this.apInvoicePaymentDetailsId = apInvoicePaymentDetailsId;
		this.referenceNo = referenceNo;
		this.invoiceTotal = invoiceTotal;
		this.invoicePayment = invoicePayment;
		this.invoiceBalance = invoiceBalance;
		this.apInvoicePaymentHeadId = apInvoicePaymentHeadId;
	}

	public int getApInvoicePaymentDetailsId() {
		return apInvoicePaymentDetailsId;
	}

	public void setApInvoicePaymentDetailsId(int apInvoicePaymentDetailsId) {
		this.apInvoicePaymentDetailsId = apInvoicePaymentDetailsId;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Long getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(Long invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public Long getInvoicePayment() {
		return invoicePayment;
	}

	public void setInvoicePayment(Long invoicePayment) {
		this.invoicePayment = invoicePayment;
	}

	public Long getInvoiceBalance() {
		return invoiceBalance;
	}

	public void setInvoiceBalance(Long invoiceBalance) {
		this.invoiceBalance = invoiceBalance;
	}

	public APInvoicePaymentHead getApInvoicePaymentHeadId() {
		return apInvoicePaymentHeadId;
	}

	public void setApInvoicePaymentHeadId(APInvoicePaymentHead apInvoicePaymentHeadId) {
		this.apInvoicePaymentHeadId = apInvoicePaymentHeadId;
	}

	@Override
	public String toString() {
		return "APInvoicePaymentDetails [apInvoicePaymentDetailsId=" + apInvoicePaymentDetailsId + ", referenceNo="
				+ referenceNo + ", invoiceTotal=" + invoiceTotal + ", invoicePayment=" + invoicePayment
				+ ", invoiceBalance=" + invoiceBalance + ", apInvoicePaymentHeadId=" + apInvoicePaymentHeadId + "]";
	}
}
