package com.inw.proy.services.deletes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;
import com.inw.proy.services.errors.PromotionDetailErrorService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("deletePromotionDetailHF")
public class PromotionDetailDeleteHF implements PromotionDetailDeleteService {
	
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	
	@Autowired
	@Qualifier("promotionDetailErrorHF")
	private PromotionDetailErrorService promotionDetailErrorService;
	
	public PromotionDetailDeleteHF() {
		promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
	}
	
	
	@Override
	public Object deleteMany(Integer[] details) { 
		
		TwoObjectsDTO response = new TwoObjectsDTO();
		ArrayList<FieldErrorDTO> errors = new ArrayList<>();
		
		if (details!=null)
			for (Integer detail : details) { 
				
				Object error =  this.delete(detail);
				if (error!=null)
					errors.add((FieldErrorDTO)  error);	
			}
		
		if (errors.size()!=0)
			response.setObjectTwo(errors);
		
		return response;
	}
	
	@Override
	public Object  delete(Integer detail) {	
		
		try {
			PromotionDetailDTO promotionDetail = new PromotionDetailDTO();
			promotionDetail.setId(detail);
			promotionDetailORM.setObject(promotionDetail);
			promotionDetailORM.deleteAndSave();	
			return null;
			
		}catch  (SQLException ex) {
			return promotionDetailErrorService
					.errorDeleting(detail);
		}
	}

}
