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
@Table(name="documentcheckdetails")
public class DocumentCheckDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="documentcheckDetailsid")	
	private int  documentcheckDetailsid;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "DocumentCheckHeadID", referencedColumnName = "DocumentCheckHeadID")
	private DocumentCheckHead  documentCheckHeadID;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Documentid", referencedColumnName = "Documentid")
	private Document  documentid;
	
	@Column(name="CheckStatus")	
	private String  checkStatus;

	public int getDocumentcheckDetailsid() {
		return documentcheckDetailsid;
	}

	public void setDocumentcheckDetailsid(int documentcheckDetailsid) {
		this.documentcheckDetailsid = documentcheckDetailsid;
	}

	public DocumentCheckHead getDocumentCheckHeadID() {
		return documentCheckHeadID;
	}

	public void setDocumentCheckHeadID(DocumentCheckHead documentCheckHeadID) {
		this.documentCheckHeadID = documentCheckHeadID;
	}

	public Document getDocumentid() {
		return documentid;
	}

	public void setDocumentid(Document documentid) {
		this.documentid = documentid;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}


	
	
}
