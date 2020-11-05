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
@Table(name="test_profile_status")
public class TestProfileStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private int s_id;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id",referencedColumnName = "profile_id")
	private TestProfile profile_id;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id",referencedColumnName = "type_id")
	private Test_type type_id;
	
	@Column(name="status")
	private int status;
	
	@Column(name="serial_no")
	private int serial_no;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public TestProfile getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(TestProfile profile_id) {
		this.profile_id = profile_id;
	}

	public Test_type getType_id() {
		return type_id;
	}

	public void setType_id(Test_type type_id) {
		this.type_id = type_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}

	public TestProfileStatus(int s_id, TestProfile profile_id, Test_type type_id, int status, int serial_no) {
		super();
		this.s_id = s_id;
		this.profile_id = profile_id;
		this.type_id = type_id;
		this.status = status;
		this.serial_no = serial_no;
	}

	public TestProfileStatus() {
		super();
		// TODO Auto-generated constructor stub
	} 

}
