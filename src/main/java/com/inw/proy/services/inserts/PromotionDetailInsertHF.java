package com.inw.proy.services.inserts;

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

@Service
@Qualifier("promotionDetailInsertHF")
public class PromotionDetailInsertHF implements PromotionDetailInsertService {

	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	
	@Autowired
	@Qualifier("checkMenuDetailHF")
	private CheckMenuDetailAccess checkMenuDetailAccess;

	@Autowired
	@Qualifier("promotionDetailErrorHF")
	private PromotionDetailErrorService promotionDetailErrorService;
	
	
	public PromotionDetailInsertHF() {
		promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
	}
	
	@Override
	public Object insertMany(PromotionDetailDTO[] details,Integer promotionId
			,Integer menuId) throws NullPointerException, SQLException {
		
		TwoObjectsDTO response = new TwoObjectsDTO();
		ArrayList<FieldErrorDTO> errors = new ArrayList<>();

		if (details!=null)
			for (PromotionDetailDTO detail : details) {
				
				Object data = this.insert(detail,promotionId,menuId);
				if (data!=null)
					errors.add((FieldErrorDTO) data);
			}
		
		if (errors.size()!=0)
			response.setObjectTwo(errors);	
	
		return response;
	}
	
	@Override
	public Object insert(PromotionDetailDTO detail,Integer promotionId,Integer menuId) throws NullPointerException, SQLException {
		
		Boolean accessToDetail = checkMenuDetailAccess.
				execute(detail.getMenuDetailId(), menuId);
		
		if (accessToDetail) {
		
			
			
			Object checkRegistredDetail = promotionDetailErrorService
											.alredyRegistredDetail(detail.getMenuDetailId(),
													promotionId);
			
			//if  is alredy registered stop the insert and return the detail of product registred in promotion
			if (checkRegistredDetail!=null)
				return checkRegistredDetail;	
			
			if (detail.getQuantity()!=null && detail.getQuantity()!=0) {
				detail.setPromotionId(promotionId);
				this.promotionDetailORM.setObject(detail);
				promotionDetailORM.addAndSave();	
				return null;
			}
			
			return promotionDetailErrorService
					.getFieldError(detail.getMenuDetailId(), "Cantidad");
		}
		
		return null;
	}
	
}
