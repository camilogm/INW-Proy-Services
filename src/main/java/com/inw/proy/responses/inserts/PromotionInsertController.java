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

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.promotion.PromotionInsertDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.inserts.PromotionDetailInsertService;
import com.inw.proy.services.inserts.PromotionInsertService;

@RestController
public class PromotionInsertController {

	
	@Autowired
	@Qualifier("promotionInsertHF")
	private PromotionInsertService promotionInsertService;
	
	
	@Autowired
	@Qualifier("promotionDetailInsertHF")
	private PromotionDetailInsertService promotionDetailInsertService;
	
	
	public PromotionInsertController() {
	}
	
	@PostMapping(value = "/promotion/create",headers = "Accept=application/json")
	private ResponseEntity<?> execute(@Valid @RequestBody PromotionInsertDTO promotion) throws NullPointerException, SQLException{
		
		PromotionInsertDTO data = (PromotionInsertDTO) promotionInsertService.execute(promotion);
		TwoObjectsDTO dataDetails = (TwoObjectsDTO) promotionDetailInsertService.insertMany(promotion.getPromotionDetails(), data.getId(), data.getMenuId());
		
		if (dataDetails.getObjectTwo()!=null) 
			return new ResponseEntity<>(
				ResponseCustom.partial_content(data, dataDetails.getObjectTwo()),HttpStatus.PARTIAL_CONTENT
				);

		else 
			return new ResponseEntity<>(
					ResponseCustom.ok(data),HttpStatus.OK
					);
		
	}
}
