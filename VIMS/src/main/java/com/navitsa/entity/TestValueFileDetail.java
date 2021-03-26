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
@Table(name = "test_value_result_detail")
public class TestValueFileDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Test_Value_File_Detail_ID")
	private int testValueDetailID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Test_Value_File_ID",referencedColumnName = "Test_Value_File_ID")
	private TestValueFileHeader test_value_file_header;
	
	@Column(name="Code")
	private String code;
	
	@Column(name="Result")
	private String result;

	public TestValueFileDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestValueFileDetail(int testValueDetailID, TestValueFileHeader test_value_file_header, String code,
			String result) {
		super();
		this.testValueDetailID = testValueDetailID;
		this.test_value_file_header = test_value_file_header;
		this.code = code;
		this.result = result;
	}
	
	public TestValueFileDetail(TestValueFileHeader test_value_file_header, String code,
			String result) {
		super();
		this.test_value_file_header = test_value_file_header;
		this.code = code;
		this.result = result;
	}

	public int getTestValueDetailID() {
		return testValueDetailID;
	}

	public void setTestValueDetailID(int testValueDetailID) {
		this.testValueDetailID = testValueDetailID;
	}

	public TestValueFileHeader getTest_value_file_header() {
		return test_value_file_header;
	}

	public void setTest_value_file_header(TestValueFileHeader test_value_file_header) {
		this.test_value_file_header = test_value_file_header;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
