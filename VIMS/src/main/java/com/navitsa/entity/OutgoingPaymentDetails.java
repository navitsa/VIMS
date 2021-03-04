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
@Table(name = "outgoingpaymentdetails")
public class OutgoingPaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="OutgoingPaymentDetailId")	
	private int outgoingPaymentDetailId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "PaymentVoucherNo", referencedColumnName = "PaymentVoucherNo")
	private OutgoingPaymentHead paymentVoucherNo;	
	
	@Column(name="GLAccNo")	
	private String glAccNo;
	
	@Column(name="Amount")	
	private long amount;
	
	@Column(name="Remarks")	
	private String remarks;

	public int getOutgoingPaymentDetailId() {
		return outgoingPaymentDetailId;
	}

	public void setOutgoingPaymentDetailId(int outgoingPaymentDetailId) {
		this.outgoingPaymentDetailId = outgoingPaymentDetailId;
	}

	public OutgoingPaymentHead getPaymentVoucherNo() {
		return paymentVoucherNo;
	}

	public void setPaymentVoucherNo(OutgoingPaymentHead paymentVoucherNo) {
		this.paymentVoucherNo = paymentVoucherNo;
	}

	public String getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(String glAccNo) {
		this.glAccNo = glAccNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public OutgoingPaymentDetails() {
		super();
	}

	public OutgoingPaymentDetails(int outgoingPaymentDetailId, OutgoingPaymentHead paymentVoucherNo, String glAccNo,
			long amount, String remarks) {
		super();
		this.outgoingPaymentDetailId = outgoingPaymentDetailId;
		this.paymentVoucherNo = paymentVoucherNo;
		this.glAccNo = glAccNo;
		this.amount = amount;
		this.remarks = remarks;
	}	

}
