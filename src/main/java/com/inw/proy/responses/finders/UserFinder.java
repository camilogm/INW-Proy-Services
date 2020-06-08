package com.inw.proy.responses.finders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserFinder {

	
	@RequestMapping(value = "/find", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> test(){ 
		
		return ResponseEntity.ok("aprobado");
	}
	
	@RequestMapping(value = "/findone", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> findone(){ 
		
		return ResponseEntity.ok("find one");
	}
	
}
