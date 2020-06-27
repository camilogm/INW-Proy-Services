package com.inw.proy.responses.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.finders.BuyFinderService;

@RestController
public class BuyFinderController {

	@Autowired
	@Qualifier("buyFinderHF")
	private BuyFinderService buyFinderService;
	
	@GetMapping(value = "/buy/find/{id}",headers = "Accept=application/json")
	public ResponseEntity<?> getBuyer(@PathVariable("id") Integer buyId) throws NullPointerException, SQLException{
		
		TwoObjectsDTO data = buyFinderService.getBuyer(buyId);
		return new ResponseEntity<>(ResponseCustom.ok(data),HttpStatus.OK);
	}
	
	@GetMapping(value = "/buy/productdetails/{id}", headers = "Accept=application/json")
	public ResponseEntity<?> getProductDetails(@PathVariable("id") Integer buyId)
			throws SQLException {
		
		Object data = buyFinderService.getProductDetails(buyId);
		
		return ResponseCustom.okJson((String)data);
		
	}
	
	@GetMapping(value = "/buy/promotiondetails/{id}",headers = "Accept=application/json")
	public ResponseEntity<?> getPromotionDetails(@PathVariable("id") Integer buyId)
			throws SQLException { 
		
		Object data = buyFinderService.getPromotionDetails(buyId);
		return ResponseCustom.okJson((String)data);
		
	}
	
}
