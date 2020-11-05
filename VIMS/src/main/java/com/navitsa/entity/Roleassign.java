package com.navitsa.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roleassign")
public class Roleassign {
	
	@EmbeddedId
	RoleassignPK roleassignPK;
	@Column(name = "Status")
	String status;
	public RoleassignPK getRoleassignPK() {
		return roleassignPK;
	}
	public void setRoleassignPK(RoleassignPK roleassignPK) {
		this.roleassignPK = roleassignPK;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
	
	
}
