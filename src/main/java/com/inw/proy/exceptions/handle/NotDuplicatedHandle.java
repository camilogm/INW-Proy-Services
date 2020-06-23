package com.inw.proy.exceptions.handle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.utils.Error;

import sv.hawklibrary.com.validators.NotDuplicatedException;

@RestControllerAdvice
public class NotDuplicatedHandle {

	
	@ExceptionHandler(value = {NotDuplicatedException.class})
	public ResponseEntity<?> execute(NotDuplicatedException ex){
		
		List<FieldErrorDTO> fieldsError = new ArrayList<>();
		
		ex.getFieldErrors().forEach(errorORM ->  {			
			fieldsError.add(new FieldErrorDTO(errorORM.getField(), errorORM.getMessage()));	
		});
		
		Error error = new Error(ex.getMessage(),fieldsError);
		
		return new ResponseEntity<>(
					ResponseCustom.bad_request(error),HttpStatus.BAD_REQUEST
				);
		
	}
	
}
