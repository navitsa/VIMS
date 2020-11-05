package com.navitsa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class RoleassignPK  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
	Role roleID;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "UserID", referencedColumnName = "userId")
	Users userID;
	public Role getRoleID() {
		return roleID;
	}
	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}
	public Users getUserID() {
		return userID;
	}
	public void setUserID(Users userID) {
		this.userID = userID;
	}
	
	
	
	
}
