package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user_level")
public class UserLevel {

	@Id
	@Column(name = "level_ID")
	private String ulid;
	
	@NotEmpty(message = "Enter a valid User Level")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Special Characters Not Allowed")
	@Column(name = "level_dsc")
	private String dsc;
	
	
	@Column(name ="status")
	private String status;

	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Special Characters Not Allowed")
	@Column(name = "remarks")
	private String remarks;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
	private Role roleID;
	
	
	public Role getRoleID() {
		return roleID;
	}

	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}

	public String getUlid() {
		return ulid;
	}

	public void setUlid(String ulid) {
		this.ulid = ulid;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public UserLevel() {
	}

	public UserLevel(String ulid) {
		this.ulid = ulid;
	}
}
