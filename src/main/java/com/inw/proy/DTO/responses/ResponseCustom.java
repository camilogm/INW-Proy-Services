package com.inw.proy.DTO.responses;

import org.springframework.http.HttpStatus;

public class ResponseCustom {

	
	public static ResponseDTO ok(Object data) {		
		return new ResponseDTO(data);
	}
	
	public static ResponseDTO bad_request(Object error) { 
		return new ResponseDTO(error, HttpStatus.BAD_REQUEST.value());
	}
	public static ResponseDTO internal_error(Object error) { 
		return new ResponseDTO(error,HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	public static ResponseDTO unauthorized(Object error) { 
		return new ResponseDTO(error,HttpStatus.UNAUTHORIZED.value());
	}
	
}
