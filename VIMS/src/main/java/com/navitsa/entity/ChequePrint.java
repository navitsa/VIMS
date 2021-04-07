package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cheque_print")
public class ChequePrint {

	@Id
	@Column(name="cheque_no")
	private String chequeNo;
	
	@Column(name="bank")
	private String bank;	

	@Column(name="bank_account")
	private String bankAccount;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_voucher_no", referencedColumnName = "PaymentVoucherNo")
	private OutgoingPaymentHead paymentVoucherNo;

}
