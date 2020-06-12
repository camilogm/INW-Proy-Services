package com.inw.proy.DTO;

import org.springframework.http.HttpStatus;

public class Response {

	
	public static ResponseDTO ok(Object data) {		
		return new ResponseDTO(data);
	}
	
	public static ResponseDTO bad_request(Object error) { 
		return new ResponseDTO(error, HttpStatus.BAD_REQUEST.value());
	}
	
}
