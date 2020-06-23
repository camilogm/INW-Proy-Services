package com.inw.proy.responses.inserts;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.menu.PromotionDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.inserts.PromotionInsertService;

@RestController
public class PromotionInsertController {

	
	@Autowired
	@Qualifier("promotionInsertHF")
	private PromotionInsertService promotionInsertService;
	
	@PostMapping(value = "/promotion/create",headers = "Accept=application/json")
	private ResponseEntity<?> execute(@Valid @RequestBody PromotionDTO promotion) throws NullPointerException, SQLException{
		
		Object data = promotionInsertService.execute(promotion);
		
		return new ResponseEntity<>(
				ResponseCustom.ok(data),HttpStatus.OK
				);
	}
}
