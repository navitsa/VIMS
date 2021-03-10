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
	
	@Column(name = "RefNo")
	private String refNo;
	
	@Column(name = "DueDate")
	private String dueDate;
	
	@Column(name = "PaymentType")
	private String paymentType;
	
	@Column(name = "ToOrderOf")
	private String toOrderOf;
	
	@Column(name = "payTo")
	private String payTo;

	@Column(name = "PaymentMean")
	private String paymentMean;

	//should calculate
	@Column(name = "totalPayment")
	private Double totalPayment;
	
	//set as active
	@Column(name = "Status")
	private String status;

	//set as pending
	@Column(name = "ChequePrint")
	private String chequePrint;
	
	//not set
	@Column(name = "PaymentDate")
	private String paymentDate;
	
	//not set
	@Column(name = "PaymentTime")
	private String paymentTime;
	
	//set default center
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Center_ID", referencedColumnName = "Center_ID")
	private CenterMaster center_ID;

	public OutgoingPaymentHead() {
		super();
	}

	public OutgoingPaymentHead(String paymentVoucherNo, String refNo, String dueDate, String paymentType,
			String toOrderOf, String payTo, String paymentMean, Double totalPayment, String status, String chequePrint,
			String paymentDate, String paymentTime, CenterMaster center_ID) {
		super();
		this.paymentVoucherNo = paymentVoucherNo;
		this.refNo = refNo;
		this.dueDate = dueDate;
		this.paymentType = paymentType;
		this.toOrderOf = toOrderOf;
		this.payTo = payTo;
		this.paymentMean = paymentMean;
		this.totalPayment = totalPayment;
		this.status = status;
		this.chequePrint = chequePrint;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.center_ID = center_ID;
	}

	public String getPaymentVoucherNo() {
		return paymentVoucherNo;
	}

	public void setPaymentVoucherNo(String paymentVoucherNo) {
		this.paymentVoucherNo = paymentVoucherNo;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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

	public String getPaymentMean() {
		return paymentMean;
	}

	public void setPaymentMean(String paymentMean) {
		this.paymentMean = paymentMean;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
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

	public CenterMaster getCenter_ID() {
		return center_ID;
	}

	public void setCenter_ID(CenterMaster center_ID) {
		this.center_ID = center_ID;
	}

}
