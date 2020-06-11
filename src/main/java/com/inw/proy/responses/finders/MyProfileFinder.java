package com.inw.proy.responses.finders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.Response;
import com.inw.proy.utils.UserDetailsLogged;

@RestController
public class MyProfileFinder {

	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> get(){ 
		return ResponseEntity.ok(userDetails.getUser());
	}
	
	@RequestMapping(value = "/my", method = RequestMethod.GET , headers="Accept=application/json")
	@PreAuthorize(value = "permitAll()")
	public ResponseEntity<?> getmy(){ 
		
		return new ResponseEntity<>(
				Response.ok(userDetails.getUser()), HttpStatus.OK
				);
				
	}
	
}
