package com.maven.spring.propertyplaceholder;

public class DAO {
	private String dbServer;

	DAO(String dbServer) {
		this.dbServer = dbServer;
	}

	@Override
	public String toString() {
		return "DAO [dbServer=" + dbServer + "]";
	}
}
