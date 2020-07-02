package com.inw.proy.responses.finders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.finders.UserFinderService;

@RestController
public class UserFinderController {

	@Autowired
	@Qualifier("userFinderHF")
	private UserFinderService userFinderService;
	
	
	@GetMapping(value = "/user/find/{id}",headers = "Accept=application/json")
	public ResponseEntity<?> execute(@PathVariable("id") Integer id) throws NullPointerException, SQLException{
		
		Object data = userFinderService.execute(id);
		
		return new ResponseEntity<>(
				ResponseCustom.ok(data),HttpStatus.OK
				);
		
	}
	
	
}
