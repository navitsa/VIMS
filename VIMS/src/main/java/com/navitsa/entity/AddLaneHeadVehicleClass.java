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
@Table(name="add_lanehead_vehicleclass")
public class AddLaneHeadVehicleClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "testLaneHead_Id", referencedColumnName = "testLaneHead_Id")
	private TestLaneHead testLaneHeadId;
	
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_Class_ID", referencedColumnName = "Vehicle_Class_ID")
	private VehicleClass vehicleClassID;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public TestLaneHead getTestLaneHeadId() {
		return testLaneHeadId;
	}


	public void setTestLaneHeadId(TestLaneHead testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}


	public VehicleClass getVehicleClassID() {
		return vehicleClassID;
	}


	public void setVehicleClassID(VehicleClass vehicleClassID) {
		this.vehicleClassID = vehicleClassID;
	}
	
	

	
}
