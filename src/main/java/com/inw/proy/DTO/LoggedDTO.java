package com.inw.proy.DTO;

import java.io.Serializable;

public class LoggedDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Boolean authenticated;
	private final User user;
	
	public LoggedDTO(Boolean authenticated, User user) {
		this.authenticated = authenticated;
		this.user = user;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public User getUser() {
		return user;
	}
}
