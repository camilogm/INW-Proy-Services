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
import com.inw.proy.services.finders.PromotionFinderService;

@RestController
public class PromotionFinderOne {

	
	@Autowired
	@Qualifier("promotionFinderHF")
	private PromotionFinderService promotionFinderService;
	
	@GetMapping(value = "/promotion/find/{id}",headers = "Accept=application/json")
	public ResponseEntity<?> find(@PathVariable("id") Integer promotionId ) throws NullPointerException, SQLException{
		
		Object data = promotionFinderService.execute(promotionId);
		
		return new ResponseEntity<>(
				ResponseCustom.ok(data),HttpStatus.OK
				);
	}
}
