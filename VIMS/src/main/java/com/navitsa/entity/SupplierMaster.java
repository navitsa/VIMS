package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_master")
public class SupplierMaster {

	@Id
	@Column(name = "supplier_id")
	private String supplierId;

	@Column(name = "supplier_name")
	String supplierName;

	public SupplierMaster() {

	}

	public SupplierMaster(String supplierId, String supplierName) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "SupplierMaster [supplierId=" + supplierId + ", supplierName=" + supplierName + "]";
	}
}
