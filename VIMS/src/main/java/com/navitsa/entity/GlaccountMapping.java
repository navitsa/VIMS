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
@Table(name = "glaccount_mapping")
public class GlaccountMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int  id;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Doc_id", referencedColumnName = "Doc_id")
	private DocType docid;
	
	@Column(name = "CR")
	private String cR;
	
	@Column(name = "DR")
	private String dR;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DocType getDocid() {
		return docid;
	}

	public void setDocid(DocType docid) {
		this.docid = docid;
	}

	public String getcR() {
		return cR;
	}

	public void setcR(String cR) {
		this.cR = cR;
	}

	public String getdR() {
		return dR;
	}

	public void setdR(String dR) {
		this.dR = dR;
	}
	
	
	
}
