package com.inw.proy.DTO;

public class Response {

	
	public static ResponseDTO ok(Object data) {		
		return new ResponseDTO(data);
	}
	
}
