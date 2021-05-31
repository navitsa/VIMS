package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_master")
public class ItemMaster {

	@Id
	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_description")
	String itemDescription;

	public ItemMaster() {

	}

	public ItemMaster(String itemCode, String itemDescription) {
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "ItemMaster [itemCode=" + itemCode + ", itemDescription=" + itemDescription + "]";
	}
}
