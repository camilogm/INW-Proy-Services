package com.inw.proy.services.updates;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;
import com.inw.proy.services.access.CheckMenuDetailAccess;
import com.inw.proy.services.errors.PromotionDetailErrorService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;

@Service
@Qualifier("promotionDetailUpdateHF")
public class PromotionDetailUpdateHF implements PromotionDetailUpdateService {

	ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	
	@Autowired
	@Qualifier("promotionDetailErrorHF")
	private PromotionDetailErrorService promotionDetailErrorService;
	
	@Autowired
	@Qualifier("checkMenuDetailHF")
	private CheckMenuDetailAccess checkMenuDetailAccess;
	
	
	public PromotionDetailUpdateHF() { 
		this.promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
	}
	
	
	@Override
	public Object updateMany(PromotionDetailDTO[] details,Integer menuId
			,Integer promotionId) throws SQLException { 
		
		TwoObjectsDTO response = new TwoObjectsDTO();
		ArrayList<FieldErrorDTO> errors = new ArrayList<>();
		
		if (details!=null)
			for (PromotionDetailDTO detail : details) { 
			
				Object error = this.udpdate(detail,menuId,promotionId);
				
				if (error!=null)
					errors.add((FieldErrorDTO) error);
			}
		
		if (errors.size()!=0)
			response.setObjectTwo(errors);
		
		return response;
	}
	
	@Override
	public Object udpdate(PromotionDetailDTO detail,Integer menuId,Integer promotionId) throws SQLException { 
		
		
		Boolean accessToDetail = checkMenuDetailAccess.
				execute(detail.getMenuDetailId(), menuId);
		
		if (!accessToDetail)
			return null;
		
		
		PromotionDetailDTO promotionDetailFound = null;
		
		try {
			if (detail.getId()!=null)
				promotionDetailFound = promotionDetailORM.find(detail.getId());
			else { 
				
				Object[][] conditions = {
						{"menu_detail_id","=",detail.getMenuDetailId(),"AND"},
						{"promotion_id","=",promotionId,null}
				};
				promotionDetailFound = promotionDetailORM.find(conditions);
				
			}
		}catch (NotFoundException ex) {
			return null;
		}
		
		if (detail.getQuantity()!=null && detail.getQuantity()!=0) {
			
			promotionDetailFound.setQuantity(detail.getQuantity());
			promotionDetailORM.setObject(promotionDetailFound);
			promotionDetailORM.updateAndSave();
			return null;
		}
		
		return promotionDetailErrorService
				.getFieldError(detail.getMenuDetailId(), "Cantidad");
	
	}
	
}
