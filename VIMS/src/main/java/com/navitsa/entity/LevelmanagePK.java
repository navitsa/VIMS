package com.navitsa.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LevelmanagePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "level_ID", referencedColumnName = "level_ID")
	private UserLevel levelID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
	private Role roleID;

	public UserLevel getLevelID() {
		return levelID;
	}

	public void setLevelID(UserLevel levelID) {
		this.levelID = levelID;
	}

	public Role getRoleID() {
		return roleID;
	}

	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}

}
