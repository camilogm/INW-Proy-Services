package com.inw.proy.utils;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.inw.proy.DTO.errors.FieldErrorDTO;
@Component
public class Error {

	private String message;
    private List<FieldErrorDTO> fieldErrors;

    public Error() {
    	
    }
    
    public Error(String message, List<FieldErrorDTO> fieldsError) {
        this.message = message;
        this.fieldErrors = fieldsError;
    }
    
    public void  setError(String message, List<FieldError> fieldsError) {
        this.message = message;
        this.fieldErrors = fieldsError == null ? null : this.setFieldError(fieldsError);
    }
    
    public String getMessage() {
        return message;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
    private  List<FieldErrorDTO> setFieldError(List<FieldError> fieldsError) {
       
		List<FieldErrorDTO> fieldErrors = new ArrayList<>();
    	fieldsError.forEach(fieldError -> { 
    		
    		 String objectName = fieldError.getField();
    		 String message = fieldError.getDefaultMessage();
    		 FieldErrorDTO error = new FieldErrorDTO(objectName, message);
    	     fieldErrors.add(error);
    	});
    	return fieldErrors;
    }
    
    public void setError(Error error) {
    	this.message = error.getMessage();
    	this.fieldErrors = error.getFieldErrors();
    }


	
}
