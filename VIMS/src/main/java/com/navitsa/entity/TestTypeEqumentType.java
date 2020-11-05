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
@Table(name = "testtype_equmenttype")
public class TestTypeEqumentType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="type_id" , referencedColumnName="type_id")
	private Test_type typeId;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Eq_Type_ID" , referencedColumnName="Eq_Type_ID")
	private EquipmentType eqTypeID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Test_type getTypeId() {
		return typeId;
	}
	public void setTypeId(Test_type typeId) {
		this.typeId = typeId;
	}
	public EquipmentType getEqTypeID() {
		return eqTypeID;
	}
	public void setEqTypeID(EquipmentType eqTypeID) {
		this.eqTypeID = eqTypeID;
	}	
	

	
}
