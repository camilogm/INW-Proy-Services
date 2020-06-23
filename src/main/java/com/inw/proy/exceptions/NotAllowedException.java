package com.inw.proy.exceptions;

public class NotAllowedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotAllowedException() {
		super("No tiene permisos para esta operación");
	}
	
	public NotAllowedException(String message) {
		super(message);
	}

	
}
