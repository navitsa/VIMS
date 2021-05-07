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

	@Column(name = "item_code")
	String itemCode;

	@Column(name = "unit_price")
	Long unitPrice;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "discount")
	Long discount;
	
	@Column(name = "total")
	Long total;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ap_invoice_head_id", referencedColumnName = "ap_invoice_head_id")
	private APInvoiceHead apInvoiceHeadId;

	public APInvoiceDetails() {

	}

	public APInvoiceDetails(int apInvoiceDetailsId, String itemCode, Long unitPrice, int quantity, Long discount,
			Long total, APInvoiceHead apInvoiceHeadId) {
		super();
		this.apInvoiceDetailsId = apInvoiceDetailsId;
		this.itemCode = itemCode;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
		this.total = total;
		this.apInvoiceHeadId = apInvoiceHeadId;
	}

	public int getApInvoiceDetailsId() {
		return apInvoiceDetailsId;
	}

	public void setApInvoiceDetailsId(int apInvoiceDetailsId) {
		this.apInvoiceDetailsId = apInvoiceDetailsId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public APInvoiceHead getApInvoiceHeadId() {
		return apInvoiceHeadId;
	}

	public void setApInvoiceHeadId(APInvoiceHead apInvoiceHeadId) {
		this.apInvoiceHeadId = apInvoiceHeadId;
	}

	@Override
	public String toString() {
		return "APInvoiceDetails [apInvoiceDetailsId=" + apInvoiceDetailsId + ", itemCode=" + itemCode + ", unitPrice="
				+ unitPrice + ", quantity=" + quantity + ", discount=" + discount + ", total=" + total
				+ ", apInvoiceHeadId=" + apInvoiceHeadId + "]";
	}
}
