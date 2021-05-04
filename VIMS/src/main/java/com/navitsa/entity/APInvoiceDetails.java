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
@Table(name = "ap_invoice_details")
public class APInvoiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ap_invoice_details_id")
	private int apInvoiceDetailsId;

	@Column(name = "description")
	String description;

	@Column(name = "amount")
	Long amount;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ap_invoice_head_id", referencedColumnName = "ap_invoice_head_id")
	private APInvoiceHead apInvoiceHeadId;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "gl_code", referencedColumnName = "GlAccNo")
	private Glaccount glAccNo;

	public APInvoiceDetails() {

	}

	public APInvoiceDetails(int apInvoiceDetailsId, String description, Long amount, APInvoiceHead apInvoiceHeadId,
			Glaccount glAccNo) {
		this.apInvoiceDetailsId = apInvoiceDetailsId;
		this.description = description;
		this.amount = amount;
		this.apInvoiceHeadId = apInvoiceHeadId;
		this.glAccNo = glAccNo;
	}

	public int getApInvoiceDetailsId() {
		return apInvoiceDetailsId;
	}

	public void setApInvoiceDetailsId(int apInvoiceDetailsId) {
		this.apInvoiceDetailsId = apInvoiceDetailsId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public APInvoiceHead getApInvoiceHeadId() {
		return apInvoiceHeadId;
	}

	public void setApInvoiceHeadId(APInvoiceHead apInvoiceHeadId) {
		this.apInvoiceHeadId = apInvoiceHeadId;
	}

	public Glaccount getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(Glaccount glAccNo) {
		this.glAccNo = glAccNo;
	}

	@Override
	public String toString() {
		return "APInvoiceDetails [apInvoiceDetailsId=" + apInvoiceDetailsId + ", description=" + description
				+ ", amount=" + amount + ", apInvoiceHeadId=" + apInvoiceHeadId + ", glAccNo=" + glAccNo + "]";
	}
}
