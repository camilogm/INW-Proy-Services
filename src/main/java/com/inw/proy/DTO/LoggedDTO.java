package com.inw.proy.DTO;

import java.io.Serializable;

public class LoggedDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Boolean authenticated;
	private final UserDTO user;
	
	public LoggedDTO(Boolean authenticated, UserDTO user) {
		this.authenticated = authenticated;
		this.user = user;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public UserDTO getUser() {
		return user;
	}
}
