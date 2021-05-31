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
	@Column(name = "Doc_id")
	private int docid;

	@Column(name = "Document")
	private String document;

	@Column(name = "doc_format")
	private String docFormat;

	@Column(name = "doc_no")
	private int docNo;

	@Column(name = "doc_no_length")
	private int docNoLength;

	public DocType() {

	}

	public DocType(int docid, String document, String docFormat, int docNo, int docNoLength) {
		super();
		this.docid = docid;
		this.document = document;
		this.docFormat = docFormat;
		this.docNo = docNo;
		this.docNoLength = docNoLength;
	}

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

	public String getDocFormat() {
		return docFormat;
	}

	public void setDocFormat(String docFormat) {
		this.docFormat = docFormat;
	}

	public int getDocNo() {
		return docNo;
	}

	public void setDocNo(int docNo) {
		this.docNo = docNo;
	}

	public int getDocNoLength() {
		return docNoLength;
	}

	public void setDocNoLength(int docNoLength) {
		this.docNoLength = docNoLength;
	}

	@Override
	public String toString() {
		return "DocType [docid=" + docid + ", document=" + document + ", docFormat=" + docFormat + ", docNo=" + docNo
				+ ", docNoLength=" + docNoLength + "]";
	}
}
