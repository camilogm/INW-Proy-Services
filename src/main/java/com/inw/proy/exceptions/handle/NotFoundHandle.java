package com.inw.proy.exceptions.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.utils.Error;

import sv.hawklibrary.com.validators.NotFoundException;

@RestControllerAdvice
public class NotFoundHandle {

	@Autowired
	private Error error;
	
	 @ExceptionHandler(value = {NotFoundException.class} )
	 public ResponseEntity<?> execute(NotFoundException ex){
		 
		 error.setError("No se encontraron resultados para su busqueda", null);
		 return new ResponseEntity<>(ResponseCustom.bad_request(error),HttpStatus.BAD_REQUEST);
	 }
}
