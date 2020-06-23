package com.inw.proy.DTO.responses;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int status;
	private final String jwt;
	private final Object data;
	private final Object error;
	
	
	public ResponseDTO(int status, String jwt, Object data, Object error) {
		this.status = status;
		this.jwt = jwt;
		this.data = data==null ? new Object() : data;
		this.error = error==null ? new Object() : error;
	}
	
	public ResponseDTO(Object data) {
		this.status = HttpStatus.OK.value();
		this.jwt = "";
		this.data = data;
		this.error = null;
		
	}
	
	public ResponseDTO(Object error,int status) { 
		this.status = status;
		this.jwt = "";
		this.data = null;
		this.error = error;
	}
	
	public int getStatus() {
		return status;
	}

	public String getJwt() {
		return jwt;
	}
	public Object getData() {
		return data;
	}


	public Object getError() {
		return error;
	}
	
	
	
	
}
