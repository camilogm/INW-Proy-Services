package com.inw.proy.responses.finders;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.finders.ShopFinderManyService;
import com.inw.proy.services.finders.ShopFinderService;

import sv.hawklibrary.com.ORM.ConditionsStructure;

@RestController
public class ShopFinderController {

	@Autowired
	@Qualifier("shopFinderManyHF")
	private ShopFinderManyService shopFinderManyService;
	
	@Autowired
	@Qualifier("shopFinderHF")
	private ShopFinderService shopFinderService;
	
	@PostMapping(value = "/shop/findmany", headers = "Accept=application/json")
	public ResponseEntity<?> execute(@Valid @RequestBody
			ConditionsStructure conditions){
		
		Object data = shopFinderManyService.execute(conditions);
		return new ResponseEntity<>
		(ResponseCustom.ok(data),HttpStatus.OK); 
		
	}
	
	@GetMapping(value = "/shop/find/{id}",headers = "Accept=application/json")
	public ResponseEntity<?> findOne(@PathVariable("id") Integer id ) throws NullPointerException, SQLException{ 
		
		Object data = shopFinderService.execute(id); 
		
		
		return new ResponseEntity<>(
				ResponseCustom.ok(data),HttpStatus.OK
				);
	}
	
}
