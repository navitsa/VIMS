package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vehicle_Sub_category")
public class VehiclesSubCategory {

	
	@Id
	@NotEmpty(message = "required")
	@Column(name="subCategoryID")
	private String subCategoryID;
	
	@Column(name="description")
	private String description;

	@Column(name="maxSpeed")
	private int maxSpeed;
	
	@Column(name="tolerance")
	private double tolerance;

	public String getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(String subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}		
	
}
