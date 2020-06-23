package com.inw.proy.responses.finders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.utils.UserDetailsLogged;

@RestController
public class MyProfileFinder {

	@Autowired
	private UserDetailsLogged userDetails;
	
	@GetMapping(value = "/myprofile",headers = "Accept=application/json")
	public ResponseEntity<?> execute(){
		
		Object data = userDetails.getUser();
		
		return new ResponseEntity<>(
				ResponseCustom.ok(data),HttpStatus.OK
				);
	}
}
