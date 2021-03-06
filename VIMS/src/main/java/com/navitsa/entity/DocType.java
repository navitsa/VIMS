package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doc_type")
public class DocType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Doc_id")	
	private int  docid;
	
	@Column(name = "Document")
	private String document;

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
	
}
