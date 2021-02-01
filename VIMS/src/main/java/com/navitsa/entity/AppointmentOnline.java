package com.navitsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointment_online")
public class AppointmentOnline {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ai_id")
	private String autoIncrementId;
	
	@Id
	@Column(name="appointment_id")
	private String appointmentID;
	
	@Column(name="customer_name")
	private String cusName;
	
	@Column(name="customer_mobileNo")
	private String cusMobileNo;
	
	@Column(name="customer_email")
	private String cusEmail;
	
	@Column(name="vehicle_no")
	private String vehicleNo;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_class_id", referencedColumnName = "Vehicle_Class_ID")
	private VehicleClass vehicleClassId;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "Category_Id")
	private TestCategory categoryId;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="appointment_date")
	private Date appointmentDate;
	
	//@Temporal(value = TemporalType.TIME)
	@Column(name="appointment_time")
	private String appointmentTime;
	
	@Column(name="status")
	private String status;

	public AppointmentOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentOnline(String appointmentID, String cusName, String cusMobileNo, String cusEmail,
			String vehicleNo, VehicleClass vehicleClassId, TestCategory categoryId, Date appointmentDate,
			String appointmentTime, String status) {
		super();
		this.appointmentID = appointmentID;
		this.cusName = cusName;
		this.cusMobileNo = cusMobileNo;
		this.cusEmail = cusEmail;
		this.vehicleNo = vehicleNo;
		this.vehicleClassId = vehicleClassId;
		this.categoryId = categoryId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusMobileNo() {
		return cusMobileNo;
	}

	public void setCusMobileNo(String cusMobileNo) {
		this.cusMobileNo = cusMobileNo;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public VehicleClass getVehicleClassId() {
		return vehicleClassId;
	}

	public void setVehicleClassId(VehicleClass vehicleClassId) {
		this.vehicleClassId = vehicleClassId;
	}

	public TestCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(TestCategory categoryId) {
		this.categoryId = categoryId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
