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
@Table(name = "gl_posting_details")
public class GlPostingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PostID")	
	private int  postID;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Journal_No", referencedColumnName = "Journal_No")
	private GlPostingHead journalNo;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "GlAccNo", referencedColumnName = "GlAccNo")
	private Glaccount glAccNo;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "Amount")
	private Long amount;

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public GlPostingHead getJournalNo() {
		return journalNo;
	}

	public void setJournalNo(GlPostingHead journalNo) {
		this.journalNo = journalNo;
	}

	public Glaccount getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(Glaccount glAccNo) {
		this.glAccNo = glAccNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	
}
