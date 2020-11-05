package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "levelmanag")
public class Levelmanage {
	
	@EmbeddedId
	private LevelmanagePK levelManagePK;
	
	@Column(name = "Status")
	private String status;

	public LevelmanagePK getLevelManagePK() {
		return levelManagePK;
	}

	public void setLevelManagePK(LevelmanagePK levelManagePK) {
		this.levelManagePK = levelManagePK;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
