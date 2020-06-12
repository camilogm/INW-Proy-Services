package com.inw.proy.DTO;

import java.util.List;

public class ErrorDTO{

	private Integer status;
	private String message;
	private List<FieldErrorDTO> errors;
	
	public ErrorDTO(Integer status, String message) {
		this.status = status;
		this.message = message;
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

	public List<FieldErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldErrorDTO> errors) {
		this.errors = errors;
	}
	
	
}
