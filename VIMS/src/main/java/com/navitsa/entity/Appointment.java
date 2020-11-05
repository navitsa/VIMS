package com.navitsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@Column(name="appointment_id")
	private String appointmentID;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="appointment_date")
	private Date appointmentDate;
	
	//@Temporal(value = TemporalType.TIME)
	@Column(name="appointment_time")
	private String appointmentTime;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "lane", referencedColumnName = "testLaneHead_Id")
	private TestLaneHead lane;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Vehicle_ID", referencedColumnName = "Vehicle_ID")
	private VehicleMaster vehicle_id;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer_id;
	
	//@ManyToOne(optional = true,fetch = FetchType.EAGER)
	//@JoinColumn(name = "owner_id", referencedColumnName = "Owner_ID")
	@Column(name="owner_id")
	private String ownerId;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
	private TestCategory categoryId;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public TestLaneHead getLane() {
		return lane;
	}

	public void setLane(TestLaneHead lane) {
		this.lane = lane;
	}

	public VehicleMaster getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(VehicleMaster vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Appointment(String appointmentID, Date appointmentDate, String appointmentTime, TestLaneHead lane,
			VehicleMaster vehicle_id, Customer customer_id, String status) {
		super();
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.lane = lane;
		this.vehicle_id = vehicle_id;
		this.customer_id = customer_id;
		this.status = status;
		//this.ownerId = owner_id;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public TestCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(TestCategory categoryId) {
		this.categoryId = categoryId;
	}


}
