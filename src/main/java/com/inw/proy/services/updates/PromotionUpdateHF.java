package com.inw.proy.services.updates;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.promotion.PromotionDTO;
import com.inw.proy.DTO.promotion.PromotionUpdateDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckWriteShopAccess;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("promotionUpdateHF")
public class PromotionUpdateHF implements PromotionUpdateService {

	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;
	
	private ORMApplicationTables<PromotionUpdateDTO> promotionORM;
	
	public PromotionUpdateHF() {
		
		this.promotionORM = new ORMApplicationTables<PromotionUpdateDTO>(PromotionUpdateDTO.class);
		
	}
	
	@Override
	public Object update(PromotionUpdateDTO promotion) throws NullPointerException, SQLException { 
		
		if (!checkWriteShopAccess.execute(
				promotion.getMenuId(),promotion.getShopId()))
			throw new NotAllowedException();
		
		PromotionDTO promotionOriginal = promotionORM.find(promotion.getId());
		
		// not avialable exception, could be in the future
		if (promotionOriginal.getMenuId() != promotion.getMenuId()) {
			throw new NotAllowedException();
		}else {
			
			if (promotion.getTotalPrice()==null || promotion.getTotalPrice()==0) {
				promotion.setTotalPrice(promotionOriginal.getTotalPrice());
			}
			promotionORM.setObject(promotion);
			promotionORM.updateAndSave();
			return promotion;
		}	
	}


	
}
