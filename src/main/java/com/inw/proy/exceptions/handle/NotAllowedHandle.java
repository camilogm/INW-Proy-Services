package com.inw.proy.exceptions.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.utils.Error;

@RestControllerAdvice
public class NotAllowedHandle {
	
	@Autowired
	private Error error;
	@ExceptionHandler(NotAllowedException.class)
	public ResponseEntity<?> execute(NotAllowedException ex){
		
		error.setError(ex.getMessage(),null);
		return new ResponseEntity<>(				
				ResponseCustom.unauthorized(error)
				,HttpStatus.UNAUTHORIZED);
	}
	

}
