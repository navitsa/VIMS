package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_parameter_category")
public class TestParameterCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_para_cat_id")
	private int test_para_cat_id;
	
	@Column(name="category_name")
	private String para_cat_name;

	public TestParameterCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestParameterCategory(int test_para_cat_id, String para_cat_name) {
		super();
		this.test_para_cat_id = test_para_cat_id;
		this.para_cat_name = para_cat_name;
	}

	public int getTest_para_cat_id() {
		return test_para_cat_id;
	}

	public void setTest_para_cat_id(int test_para_cat_id) {
		this.test_para_cat_id = test_para_cat_id;
	}

	public String getPara_cat_name() {
		return para_cat_name;
	}

	public void setPara_cat_name(String para_cat_name) {
		this.para_cat_name = para_cat_name;
	}

}
