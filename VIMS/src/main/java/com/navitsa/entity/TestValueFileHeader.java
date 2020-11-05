package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_value_result_header")
public class TestValueFileHeader {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Test_Value_File_ID")
	private int test_value_file_id;
	
	@Column(name="Vehicle_ID")
	private String vehicle_id;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="Time")
	private String time;
	
	@Column(name="TextFile_Name")
	private String txtFileName;
	
	@Column(name="Status")
	private String status;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Register_ID",referencedColumnName = "V_Register_ID")
	private VehicleRegistration vreg;

	public TestValueFileHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestValueFileHeader(int test_value_file_id, String vehicle_id, String date, String time, String txtFileName,
			String status, VehicleRegistration vreg) {
		super();
		this.test_value_file_id = test_value_file_id;
		this.vehicle_id = vehicle_id;
		this.date = date;
		this.time = time;
		this.txtFileName = txtFileName;
		this.status = status;
		this.vreg = vreg;
	}



	public int getTest_value_file_id() {
		return test_value_file_id;
	}

	public void setTest_value_file_id(int test_value_file_id) {
		this.test_value_file_id = test_value_file_id;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTxtFileName() {
		return txtFileName;
	}

	public void setTxtFileName(String txtFileName) {
		this.txtFileName = txtFileName;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public VehicleRegistration getVreg() {
		return vreg;
	}

	public void setVreg(VehicleRegistration vreg) {
		this.vreg = vreg;
	}

}
