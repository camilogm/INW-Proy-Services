
  package com.inw.proy.exceptions.handle;
  

  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order; 
  import org.springframework.http.HttpStatus; 
  import org.springframework.http.ResponseEntity; 
  import org.springframework.validation.BindingResult; 
  import org.springframework.validation.FieldError; 
  import org.springframework.web.bind.MethodArgumentNotValidException; 
  import org.springframework.web.bind.annotation.ExceptionHandler; 
  import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.utils.Error;
  import java.util.List;
  
  @RestControllerAdvice
  @Order(1) 
  public class MethodArgumentNotValidExceptionHandle {
  
	@Autowired
	private Error error;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> execute(MethodArgumentNotValidException ex) {

	
		HttpStatus status = HttpStatus.BAD_REQUEST;
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		error.setError("Error al ingresar los datos ", fieldErrors);

		return new ResponseEntity<>(ResponseCustom.bad_request(error), status);
	}

}
