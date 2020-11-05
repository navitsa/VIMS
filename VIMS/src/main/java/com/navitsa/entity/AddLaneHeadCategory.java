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
@Table(name="add_lanehead_category")
public class AddLaneHeadCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "testLaneHead_Id", referencedColumnName = "testLaneHead_Id")
	private TestLaneHead testLaneHeadId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
	private TestCategory categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TestLaneHead getTestLaneHeadId() {
		return testLaneHeadId;
	}

	public void setTestLaneHeadId(TestLaneHead testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}

	public TestCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(TestCategory categoryId) {
		this.categoryId = categoryId;
	}
	

}
