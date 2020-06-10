package com.inw.proy.utils;

import java.awt.List;

import org.springframework.stereotype.Component;

@Component
public class Error {

	private int status;
	private String message;
	private List fieldErrors ;
	
	
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public List getFieldErrors() {
		return fieldErrors;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setFieldErrors(List fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	public void setError(int status, String message, List list) {
		this.status = status;
		this.message = message;
		this.fieldErrors = list;
	}
	
}
