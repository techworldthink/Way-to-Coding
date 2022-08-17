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

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

}
