package com.inw.proy.responses.finders;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserFinder {

	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> test(@PathVariable("id") String id ){ 
		
		return ResponseEntity.ok("aprobado");
	}
	
	
	@RequestMapping(value = "/findone", method = RequestMethod.GET , headers="Accept=application/json")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> findone(){ 
		
		return ResponseEntity.ok("find one");
	}
	
	@RequestMapping(value = "/findtwo", method = RequestMethod.GET , headers="Accept=application/json")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> findonfe(){ 
		
		return ResponseEntity.ok("find two");
	}
	
	
}
