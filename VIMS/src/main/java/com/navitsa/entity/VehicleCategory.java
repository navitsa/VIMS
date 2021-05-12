package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vehicle_category")
public class VehicleCategory {

	@Id
	@NotEmpty(message = "required")
	@Column(name = "categoryID")
	private String categoryID;

	@Column(name = "vehicleCategory")
	private String vehicleCategory;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "status")
	private String status;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Type_ID" , referencedColumnName="Type_ID" )
	private VehicleCategoryType typeId;
	
	

	public VehicleCategoryType getTypeId() {
		return typeId;
	}

	public void setTypeId(VehicleCategoryType typeId) {
		this.typeId = typeId;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
