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
@Table(name="inventory_location")
public class InventoryLocation  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="invLoID")
	private int invLoID;
	
	@Column(name ="invLocationcol")
	private String invLocationcol;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name ="Center_ID" , referencedColumnName="Center_ID")
	private CenterMaster centerID;

	public int getInvLoID() {
		return invLoID;
	}

	public void setInvLoID(int invLoID) {
		this.invLoID = invLoID;
	}

	public String getInvLocationcol() {
		return invLocationcol;
	}

	public void setInvLocationcol(String invLocationcol) {
		this.invLocationcol = invLocationcol;
	}

	public CenterMaster getCenterID() {
		return centerID;
	}

	public void setCenterID(CenterMaster centerID) {
		this.centerID = centerID;
	}
	
	
	
}
