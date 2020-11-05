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
@Table(name = "visual_checklist_master")
public class VisualChecklistMaster {
	
	@Id
	@Column(name="Visual_Checklist_ID")
	private String cheklistID;
	
	//@NotEmpty(message = "Please select conducted on time")
	@Temporal(value = TemporalType.DATE)
	@Column(name="Date")
	private Date date;
	
	//@NotEmpty(message = "Please select conducted on time")
	@Temporal(value = TemporalType.TIME)
	@Column(name="Start_Time")
	private Date time;
	
	//@NotEmpty(message = "Please select end on time")
	@Temporal(value = TemporalType.TIME)
	@Column(name="End_time")
	private Date endtime;
	
	//@NotEmpty(message = "Please select overall status")
	@Column(name="Status")
	private String overallstatus;
	
	//@NotEmpty(message = "Please enter overall remark")
	@Column(name="Remark")
	private String overallremark;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Register_ID",referencedColumnName = "V_Register_ID")
	private VehicleRegistration vr;
	
	@Column(name="Partner_ID")
	private String partnerID;
	
	@Column(name="Vehicle_ID")
	private String vehicleID;
	
	@Column(name="Fuel_Type_ID")
	private String fuelTypeID;
	
	@Column(name="Center_ID")
	private String centerID;
	
	@Column(name="Lane_ID")
	private String laneID;
	
	@Column(name="Visual_Profile_ID")
	private String profileID;
	
	@Column(name="UserId")
	private String userID;

	public VisualChecklistMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisualChecklistMaster(String cheklistID, Date date, Date time, Date endtime, String overallstatus,
			String overallremark, VehicleRegistration vr, String partnerID, String vehicleID, String fuelTypeID,
			String centerID, String laneID, String profileID, String userID) {
		super();
		this.cheklistID = cheklistID;
		this.date = date;
		this.time = time;
		this.endtime = endtime;
		this.overallstatus = overallstatus;
		this.overallremark = overallremark;
		this.vr = vr;
		this.partnerID = partnerID;
		this.vehicleID = vehicleID;
		this.fuelTypeID = fuelTypeID;
		this.centerID = centerID;
		this.laneID = laneID;
		this.profileID = profileID;
		this.userID = userID;
	}

	public String getCheklistID() {
		return cheklistID;
	}

	public void setCheklistID(String cheklistID) {
		this.cheklistID = cheklistID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getOverallstatus() {
		return overallstatus;
	}

	public void setOverallstatus(String overallstatus) {
		this.overallstatus = overallstatus;
	}

	public String getOverallremark() {
		return overallremark;
	}

	public void setOverallremark(String overallremark) {
		this.overallremark = overallremark;
	}

	public VehicleRegistration getVr() {
		return vr;
	}

	public void setVr(VehicleRegistration vr) {
		this.vr = vr;
	}

	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getFuelTypeID() {
		return fuelTypeID;
	}

	public void setFuelTypeID(String fuelTypeID) {
		this.fuelTypeID = fuelTypeID;
	}

	public String getCenterID() {
		return centerID;
	}

	public void setCenterID(String centerID) {
		this.centerID = centerID;
	}

	public String getLaneID() {
		return laneID;
	}

	public void setLaneID(String laneID) {
		this.laneID = laneID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
