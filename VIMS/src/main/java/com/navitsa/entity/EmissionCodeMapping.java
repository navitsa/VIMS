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
@Table(name = "emission_code_mapping")
public class EmissionCodeMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="column_name")
	private String columnName;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "test_type_id",referencedColumnName = "type_id")
	private Test_type testType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Test_type getTestType() {
		return testType;
	}

	public void setTestType(Test_type testType) {
		this.testType = testType;
	}

	public EmissionCodeMapping() {
		super();
	}

	public EmissionCodeMapping(int id, String code, String columnName, Test_type testType) {
		super();
		this.id = id;
		this.code = code;
		this.columnName = columnName;
		this.testType = testType;
	}
	
}
