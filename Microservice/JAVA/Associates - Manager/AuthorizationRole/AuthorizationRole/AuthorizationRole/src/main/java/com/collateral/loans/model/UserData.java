package com.collateral.loans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity(name = "user")
@Table
public class UserData {

	@Id
	@Column(name = "userid", length = 20)
	private String userid;
	@Column(name = "upassword", length = 20)
	private String upassword;
	@Column(name = "uname", length = 20)
	private String uname;
	private String authToken;
	private String authRole;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public UserData(String userid, String upassword, String uname, String authToken) {
		super();
		this.userid = userid;
		this.upassword = upassword;
		this.uname = uname;
		this.authToken = authToken;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAuthRole() {
		return authRole;
	}
	public void setAuthRole(String authRole) {
		this.authRole = authRole;
	}
	public UserData(String authRole) {
		super();
		this.authRole = authRole;
	}
	
	
	
	

}
