package com.inw.proy.DTO;

public class FieldErrorDTO {

	@SuppressWarnings("unused")
	private final String field;
	@SuppressWarnings("unused")
	private final String message;
	
	public FieldErrorDTO(String field, String message) {
		this.field = field;
		this.message = message;
	}
	
}
