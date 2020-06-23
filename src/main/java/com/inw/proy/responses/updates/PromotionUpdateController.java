package com.inw.proy.responses.updates;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.promotion.PromotionUpdateDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.deletes.PromotionDetailDeleteService;
import com.inw.proy.services.inserts.PromotionDetailInsertService;
import com.inw.proy.services.updates.PromotionDetailUpdateService;
import com.inw.proy.services.updates.PromotionUpdateService;

@RestController
public class PromotionUpdateController {

	@Autowired
	@Qualifier("promotionUpdateHF")
	private PromotionUpdateService promotionUpdateService;
	
	@Autowired
	@Qualifier("promotionDetailUpdateHF")
	private PromotionDetailUpdateService promotionDetailUpdateService;
	
	@Autowired
	@Qualifier("promotionDetailInsertHF")
	private PromotionDetailInsertService promotionDetailInsertService;
	
	@Autowired
	@Qualifier("promotionDetailDeleteHF")
	private PromotionDetailDeleteService promotionDetailDeleteService;
	
	
	@SuppressWarnings("unchecked")
	@PreAuthorize("hasRole('ROLE_vendedor')")
	@PatchMapping(value = "/promotion/update",headers = "Accept=application/json")
	public ResponseEntity<?> execute ( @Valid @RequestBody PromotionUpdateDTO promotion) throws NullPointerException, SQLException{
		
		Object data = promotionUpdateService.update(promotion);
		
		TwoObjectsDTO dataDetailsInsert = (TwoObjectsDTO) promotionDetailInsertService
														  	.insertMany(promotion.getNewDetails(), 
														  			promotion.getId(), promotion.getMenuId());
				
				
		TwoObjectsDTO dataDetailsUpdate = (TwoObjectsDTO) promotionDetailUpdateService
										.updateMany(
												promotion.getUpdateDetails(),
												promotion.getMenuId(),
												promotion.getId());
		
		TwoObjectsDTO dataDetailsDelete = (TwoObjectsDTO) promotionDetailDeleteService
															.deleteMany(promotion.getDeleteDetails());
		
		ArrayList<FieldErrorDTO> errors = new ArrayList<>();
		
		if (dataDetailsInsert.getObjectTwo()!=null)
			errors.addAll((ArrayList<FieldErrorDTO>) dataDetailsInsert.getObjectTwo());
		if (dataDetailsUpdate.getObjectTwo()!=null)
			errors.addAll((ArrayList<FieldErrorDTO>) dataDetailsUpdate.getObjectTwo());
		if (dataDetailsDelete.getObjectTwo()!=null)
			errors.addAll( (ArrayList<FieldErrorDTO>) dataDetailsDelete.getObjectTwo() );
		
		
		if (errors.size()!=0) {
			return new ResponseEntity<>(ResponseCustom.partial_content(
					data, dataDetailsInsert.getObjectTwo()),
					HttpStatus.PARTIAL_CONTENT);
			}
		else 
			return new ResponseEntity<>(
					ResponseCustom.ok(data),HttpStatus.OK
					);
		
	}
}
