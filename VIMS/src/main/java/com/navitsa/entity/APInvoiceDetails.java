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
	private APInvoiceHead apInvoiceHead;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_code", referencedColumnName = "item_code")
	private ItemMaster itemMaster;

	public APInvoiceDetails() {

	}

	public APInvoiceDetails(int apInvoiceDetailsId, Long unitPrice, int quantity, Long discount, Long total,
			APInvoiceHead apInvoiceHead, ItemMaster itemMaster) {
		super();
		this.apInvoiceDetailsId = apInvoiceDetailsId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
		this.total = total;
		this.apInvoiceHead = apInvoiceHead;
		this.itemMaster = itemMaster;
	}

	public int getApInvoiceDetailsId() {
		return apInvoiceDetailsId;
	}

	public void setApInvoiceDetailsId(int apInvoiceDetailsId) {
		this.apInvoiceDetailsId = apInvoiceDetailsId;
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

	public APInvoiceHead getApInvoiceHead() {
		return apInvoiceHead;
	}

	public void setApInvoiceHead(APInvoiceHead apInvoiceHead) {
		this.apInvoiceHead = apInvoiceHead;
	}

	public ItemMaster getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	@Override
	public String toString() {
		return "APInvoiceDetails [apInvoiceDetailsId=" + apInvoiceDetailsId + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + ", discount=" + discount + ", total=" + total + ", apInvoiceHead=" + apInvoiceHead
				+ ", itemMaster=" + itemMaster + "]";
	}
}
