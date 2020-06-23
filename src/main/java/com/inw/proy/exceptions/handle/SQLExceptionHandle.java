package com.inw.proy.exceptions.handle;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.utils.Error;

@RestControllerAdvice
public class SQLExceptionHandle {

	@Autowired
	private Error error;
	
	@ExceptionHandler(value = {SQLException.class})
	public ResponseEntity<?> execute(SQLException ex){ 
		
		System.out.println(ex);
		error.setError("Error interno, no se pudo comprobar ciertas dependencias",null);	
		return new ResponseEntity<>(ResponseCustom.internal_error(error),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
