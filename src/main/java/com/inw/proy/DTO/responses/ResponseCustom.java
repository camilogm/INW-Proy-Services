package com.inw.proy.DTO.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseCustom {

	
	public static ResponseDTO ok(Object data) {		
		return new ResponseDTO(data);
	}
	public static ResponseDTO partial_content(Object data, Object error) {		
		return new ResponseDTO(HttpStatus.PARTIAL_CONTENT.value(),"",data,error);
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
	public static ResponseEntity<?> okJson(String data){	
		String body = "" ; 
		body += "{\"status\":"+HttpStatus.OK.value() +", ";
		body += "\"data\":["+data+"],";
		body += "\"errors\":null}";	
		return ResponseEntity.ok().body(body);
	}
	
}
