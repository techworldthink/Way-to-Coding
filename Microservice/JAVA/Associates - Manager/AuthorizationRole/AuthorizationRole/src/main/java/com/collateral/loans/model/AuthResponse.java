package com.collateral.loans.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class AuthResponse {
	private String uid;
	private String name;
	private boolean isValid;
	private String role;
	public AuthResponse(String role) {
		super();
		this.role = role;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public AuthResponse(String uid, String name, boolean isValid) {
		super();
		this.uid = uid;
		this.name = name;
		this.isValid = isValid;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuthResponse [uid=" + uid + ", name=" + name + ", isValid=" + isValid + "]";
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
