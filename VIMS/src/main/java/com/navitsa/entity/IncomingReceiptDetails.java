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
@Table(name = "incomingreceiptdetails")
public class IncomingReceiptDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="incRecDetailId")	
	private int incRecDetailId;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "inRecNo", referencedColumnName = "inRecNo")
	private IncomingReceiptHead inRecNo;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_ID", referencedColumnName = "Vehicle_ID")
	private VehicleMaster vehicle_ID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "invoiceNo", referencedColumnName = "invoiceNo")
	private InvoiceHead invoiceNo;
	
	@Column(name = "invTotal")
	private Long invTotal;
	
	@Column(name = "invBalance")
	private Long invBalance;
	
	@Column(name = "payAmount")
	private Long payAmount;
	
	@Column(name = "curBalance")
	private Long curBalance;
	//incRecDetailId
	//inRecNo

	public IncomingReceiptDetails() {
		
		// TODO Auto-generated constructor stub
	}

	public int getIncRecDetailId() {
		return incRecDetailId;
	}

	public void setIncRecDetailId(int incRecDetailId) {
		this.incRecDetailId = incRecDetailId;
	}

	public IncomingReceiptHead getInRecNo() {
		return inRecNo;
	}

	public void setInRecNo(IncomingReceiptHead inRecNo) {
		this.inRecNo = inRecNo;
	}

	public VehicleMaster getVehicle_ID() {
		return vehicle_ID;
	}

	public void setVehicle_ID(VehicleMaster vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}

	public InvoiceHead getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(InvoiceHead invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Long getInvTotal() {
		return invTotal;
	}

	public void setInvTotal(Long invTotal) {
		this.invTotal = invTotal;
	}

	public Long getInvBalance() {
		return invBalance;
	}

	public void setInvBalance(Long invBalance) {
		this.invBalance = invBalance;
	}

	public Long getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}

	public Long getCurBalance() {
		return curBalance;
	}

	public void setCurBalance(Long curBalance) {
		this.curBalance = curBalance;
	}
	

	
	
	
	
}
