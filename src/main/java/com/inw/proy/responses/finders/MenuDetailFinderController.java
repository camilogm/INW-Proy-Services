package com.inw.proy.responses.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.finders.MenuDetailFinderService;

@RestController
public class MenuDetailFinderController {

	@Autowired
	@Qualifier("menuDetailFinderHF")
	private MenuDetailFinderService menuDetailFinderService;
	
	
	@GetMapping(value = "/menu/details/{menuId}",headers = "Accept=application/json")
	public ResponseEntity<?> execute(@PathVariable("menuId") Integer menuId) throws NullPointerException, SQLException{
		
		Object data = menuDetailFinderService.execute(menuId);
		return new ResponseEntity<>(ResponseCustom.ok(data),HttpStatus.OK);
	}
}
