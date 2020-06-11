package com.inw.proy.utils;

import java.awt.List;

import org.springframework.stereotype.Component;

@Component
public class Error {

	private String message;
	private List fieldErrors ;
	
	public String getMessage() {
		return message;
	}
	public List getFieldErrors() {
		return fieldErrors;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setFieldErrors(List fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	public void setError( String message, List list) {
		this.message = message;
		this.fieldErrors = list;
	}
	
	public void setError(Error error) {
		this.message = error.getMessage();
		this.fieldErrors = error.getFieldErrors();
	}
	
}
