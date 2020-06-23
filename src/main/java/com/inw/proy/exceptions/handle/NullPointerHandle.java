package com.inw.proy.exceptions.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.utils.Error;

@RestControllerAdvice
public class NullPointerHandle {

	@Autowired
	private Error error;
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<?> execute(NullPointerException ex){
		
		ex.fillInStackTrace();	
		error.setError("Error interno (null pointer pa mientras revisas che)  ",null);
		
		return new ResponseEntity<>(
				ResponseCustom.internal_error(error),HttpStatus.INTERNAL_SERVER_ERROR				
				);
				
	}
}
