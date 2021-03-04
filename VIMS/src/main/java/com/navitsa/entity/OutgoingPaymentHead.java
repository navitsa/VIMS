package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "outgoingpaymenthead")
public class OutgoingPaymentHead {

	@Id
	@Column(name = "PaymentVoucherNo")
	private String paymentVoucherNo;
	
	@Column(name = "AcType")
	private String acType;
	
	//not set
	@Column(name = "PaymentDate")
	private String paymentDate;
	
	//not set
	@Column(name = "PaymentTime")
	private String paymentTime;
	
	@Column(name = "DueDate")
	private String dueDate;
	
	@Column(name = "ToOrderOf")
	private String toOrderOf;
	
	@Column(name = "payTo")
	private String payTo;
	
	//should calculate
	@Column(name = "totalPayment")
	private long totalPayment;
	
	@Column(name = "PayType")
	private String payType;
	
	@Column(name = "ChequeNo")
	private String chequeNo;
	
	//set as active
	@Column(name = "Status")
	private String status;

	//set as pending
	@Column(name = "ChequePrint")
	private String chequePrint;
	
	//set default center
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Center_ID", referencedColumnName = "Center_ID")
	private CenterMaster center_ID;
	
	@Column(name = "RefNo")
	private String refNo;

	public String getPaymentVoucherNo() {
		return paymentVoucherNo;
	}

	public void setPaymentVoucherNo(String paymentVoucherNo) {
		this.paymentVoucherNo = paymentVoucherNo;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getToOrderOf() {
		return toOrderOf;
	}

	public void setToOrderOf(String toOrderOf) {
		this.toOrderOf = toOrderOf;
	}

	public String getPayTo() {
		return payTo;
	}

	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	public long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(long totalPayment) {
		this.totalPayment = totalPayment;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChequePrint() {
		return chequePrint;
	}

	public void setChequePrint(String chequePrint) {
		this.chequePrint = chequePrint;
	}

	public CenterMaster getCenter_ID() {
		return center_ID;
	}

	public void setCenter_ID(CenterMaster center_ID) {
		this.center_ID = center_ID;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public OutgoingPaymentHead() {
		super();
	}

	public OutgoingPaymentHead(String paymentVoucherNo, String acType, String paymentDate, String paymentTime,
			String dueDate, String toOrderOf, String payTo, long totalPayment, String payType, String chequeNo,
			String status, String chequePrint, CenterMaster center_ID, String refNo) {
		super();
		this.paymentVoucherNo = paymentVoucherNo;
		this.acType = acType;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.dueDate = dueDate;
		this.toOrderOf = toOrderOf;
		this.payTo = payTo;
		this.totalPayment = totalPayment;
		this.payType = payType;
		this.chequeNo = chequeNo;
		this.status = status;
		this.chequePrint = chequePrint;
		this.center_ID = center_ID;
		this.refNo = refNo;
	}


}
