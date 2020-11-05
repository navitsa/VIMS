package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ftp_server_info_esout")
public class FtpServerInfoEsout {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "ip_address")
	private String ip_address;
	
	@Column(name = "port")
	private int port;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "download_path")
	private String download_path;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Center_ID",referencedColumnName = "Center_ID")
	private CenterMaster center_id;
	
	public FtpServerInfoEsout() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FtpServerInfoEsout(int id, String ip_address, int port, String username, String password,
			String download_path, CenterMaster center_id) {
		super();
		this.id = id;
		this.ip_address = ip_address;
		this.port = port;
		this.username = username;
		this.password = password;
		this.download_path = download_path;
		this.center_id = center_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDownload_path() {
		return download_path;
	}
	public void setDownload_path(String download_path) {
		this.download_path = download_path;
	}
	public CenterMaster getCenter_id() {
		return center_id;
	}
	public void setCenter_id(CenterMaster center_id) {
		this.center_id = center_id;
	}
}
