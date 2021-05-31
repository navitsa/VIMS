package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ap_invoice_payment_head")
public class APInvoicePaymentHead {

	@Id
	@Column(name = "ap_payment_head_id")
	private String apInvoicePaymentHeadId;

	@Column(name = "payment_date")
	String paymentDate;

	@Column(name = "payment_time")
	String paymentTime;

	@Column(name = "total_due")
	Long totalDue;

	@Column(name = "total_payment")
	Long totalPayment;

	@Column(name = "total_balance")
	Long totalBalance;

	@Column(name = "payment_type")
	String paymentType;

	@Column(name = "card_number")
	String cardNumber;

	@Column(name = "expiry_date")
	String expiryDate;

	@Column(name = "bank_id")
	String bankId;

	@Column(name = "cheque_number")
	String chequeNumber;

	@Column(name = "cheque_due_date")
	String chequeDueDate;

	@Column(name = "bank_account_number")
	String bankAccountNumber;

	@Column(name = "bank_charges")
	Long bankCharges;

	@Column(name = "center_id")
	String centerId;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
	private SupplierMaster supplierMaster;

	public APInvoicePaymentHead() {

	}

	public APInvoicePaymentHead(String apInvoicePaymentHeadId, String paymentDate, String paymentTime, Long totalDue,
			Long totalPayment, Long totalBalance, String paymentType, String cardNumber, String expiryDate,
			String bankId, String chequeNumber, String chequeDueDate, String bankAccountNumber, Long bankCharges,
			String centerId, SupplierMaster supplierMaster) {
		this.apInvoicePaymentHeadId = apInvoicePaymentHeadId;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.totalDue = totalDue;
		this.totalPayment = totalPayment;
		this.totalBalance = totalBalance;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankId = bankId;
		this.chequeNumber = chequeNumber;
		this.chequeDueDate = chequeDueDate;
		this.bankAccountNumber = bankAccountNumber;
		this.bankCharges = bankCharges;
		this.centerId = centerId;
		this.supplierMaster = supplierMaster;
	}

	public String getApInvoicePaymentHeadId() {
		return apInvoicePaymentHeadId;
	}

	public void setApInvoicePaymentHeadId(String apInvoicePaymentHeadId) {
		this.apInvoicePaymentHeadId = apInvoicePaymentHeadId;
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

	public Long getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Long totalDue) {
		this.totalDue = totalDue;
	}

	public Long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Long totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Long totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getChequeDueDate() {
		return chequeDueDate;
	}

	public void setChequeDueDate(String chequeDueDate) {
		this.chequeDueDate = chequeDueDate;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public Long getBankCharges() {
		return bankCharges;
	}

	public void setBankCharges(Long bankCharges) {
		this.bankCharges = bankCharges;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public SupplierMaster getSupplierMaster() {
		return supplierMaster;
	}

	public void setSupplierMaster(SupplierMaster supplierMaster) {
		this.supplierMaster = supplierMaster;
	}

	@Override
	public String toString() {
		return "APInvoicePaymentHead [apInvoicePaymentHeadId=" + apInvoicePaymentHeadId + ", paymentDate=" + paymentDate
				+ ", paymentTime=" + paymentTime + ", totalDue=" + totalDue + ", totalPayment=" + totalPayment
				+ ", totalBalance=" + totalBalance + ", paymentType=" + paymentType + ", cardNumber=" + cardNumber
				+ ", expiryDate=" + expiryDate + ", bankId=" + bankId + ", chequeNumber=" + chequeNumber
				+ ", chequeDueDate=" + chequeDueDate + ", bankAccountNumber=" + bankAccountNumber + ", bankCharges="
				+ bankCharges + ", centerId=" + centerId + ", supplierMaster=" + supplierMaster + "]";
	}
}
