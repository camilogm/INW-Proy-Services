package com.inw.proy.exceptions.handle;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.exceptions.NotAllowedException;

@RestControllerAdvice
@Order(1)
public class NotAllowedHandle {
	
	@ExceptionHandler(NotAllowedException.class)
	public ResponseEntity<?> execute(NotAllowedException ex){
		return new ResponseEntity<>("no rey",HttpStatus.BAD_REQUEST);
	}
	

}
