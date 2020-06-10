package com.inw.proy.DTO;

import java.awt.List;

public class ErrorDTO{

	private Integer status;
	private String message;
	private List errors;
	
	public ErrorDTO(Integer status, String message,List errors) {
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public Integer getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public List getErrors() {
		return errors;
	}

	public void setErrors(List errors) {
		this.errors = errors;
	}
	
	
}
