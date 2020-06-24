package com.inw.proy.responses.deletes;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.deletes.PromotionDeleteService;

@RestController
public class PromotionDeleteController {

	@Autowired
	@Qualifier("promotionDeleteHF")
	private PromotionDeleteService promotionDeleteService;
	
	
	@DeleteMapping(value = "/promotion/delete/{promotionId}",headers = "Accept=application/json")
	public ResponseEntity<?> execute(@PathVariable("promotionId") Integer promotionId ) throws NullPointerException, SQLException{ 
		
		Object data = promotionDeleteService.execute(promotionId);
		return new ResponseEntity<>(ResponseCustom.ok(data),HttpStatus.OK);
	}
}
