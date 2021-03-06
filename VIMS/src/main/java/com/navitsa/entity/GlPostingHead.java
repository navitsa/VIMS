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
@Table(name = "gl_posting_head")
public class GlPostingHead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Journal_No")	
	private int  journalNo;
	
	@Column(name = "doc_No")
	private String docNo;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Doc_id", referencedColumnName = "Doc_id")
	private DocType docid;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name ="Center_ID" , referencedColumnName="Center_ID")
	private CenterMaster centerID;
	
	@Column(name = "Date")
	private String date;
	
	@Column(name = "Time")
	private String time;
	
	@Column(name = "Total_DR")
	private Long totalDR;
	
	@Column(name = "Total_CR")
	private Long totalCR;
	
	@Column(name = "Status")
	private String status;

	public int getJournalNo() {
		return journalNo;
	}

	public void setJournalNo(int journalNo) {
		this.journalNo = journalNo;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public DocType getDocid() {
		return docid;
	}

	public void setDocid(DocType docid) {
		this.docid = docid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getTotalDR() {
		return totalDR;
	}

	public void setTotalDR(Long totalDR) {
		this.totalDR = totalDR;
	}

	public Long getTotalCR() {
		return totalCR;
	}

	public void setTotalCR(Long totalCR) {
		this.totalCR = totalCR;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CenterMaster getCenterID() {
		return centerID;
	}

	public void setCenterID(CenterMaster centerID) {
		this.centerID = centerID;
	}
	
	
	
	
	
}
