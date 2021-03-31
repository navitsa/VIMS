package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuel_type")
public class FuelType {

	@Id
	@Column(name = "Fuel_Type_ID")
	private String fuelTypeID;

	@Column(name = "Fuel")
	private String fuel;

	public String getFuelTypeID() {
		return fuelTypeID;
	}

	public void setFuelTypeID(String fuelTypeID) {
		this.fuelTypeID = fuelTypeID;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public FuelType() {
		super();
	}

	public FuelType(String fuelTypeID, String fuel) {
		super();
		this.fuelTypeID = fuelTypeID;
		this.fuel = fuel;
	}

}
