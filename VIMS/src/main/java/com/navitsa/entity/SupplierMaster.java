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

	@Column(name = "supplier_address")
	String supplierAddress;

	@Column(name = "contact_no")
	String contactNo;

	@Column(name = "email")
	String email;

	public SupplierMaster() {

	}

	public SupplierMaster(String supplierId, String supplierName, String supplierAddress, String contactNo,
			String email) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.contactNo = contactNo;
		this.email = email;
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

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SupplierMaster [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierAddress="
				+ supplierAddress + ", contactNo=" + contactNo + ", email=" + email + "]";
	}
}
