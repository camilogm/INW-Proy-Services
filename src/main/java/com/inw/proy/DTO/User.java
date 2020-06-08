package com.inw.proy.DTO;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwt;
	private final String userRol;
	private final String name;
	private final String lastName;
	
	public User(String jwt, String userRol,String name, String lastName) {
		this.jwt = jwt;
		this.userRol = userRol;
		this.name=name;
		this.lastName=lastName;
	}

	public String getJwt() {
		return jwt;
	}

	public String getUserRol() {
		return userRol;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
	
	
}
