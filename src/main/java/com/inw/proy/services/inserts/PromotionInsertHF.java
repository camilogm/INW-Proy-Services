package com.inw.proy.services.inserts;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.PromotionDTO;
import com.inw.proy.DTO.menu.PromotionDetailDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckMenuDetailAccess;
import com.inw.proy.services.access.CheckWriteShopAccess;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotDuplicatedException;
import sv.hawklibrary.com.validators.RandomInt;

@Service
@Qualifier("promotionInsertHF")
public class PromotionInsertHF implements PromotionInsertService {
	
	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;

	@Autowired
	@Qualifier("checkMenuDetailHF")
	private CheckMenuDetailAccess checkMenuDetailAccess;
	
	private ORMApplicationTables<PromotionDTO> promotionORM;
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	private RandomInt randomInt;
	
	public PromotionInsertHF() {
		
		promotionORM = new ORMApplicationTables<>(PromotionDTO.class);
		promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
		randomInt = new RandomInt();
	}
	
	@Override
	public Object execute(PromotionDTO promotion) throws NullPointerException, SQLException {
		
		
		if (!checkWriteShopAccess.execute(promotion.getShopId()))
			throw new NotAllowedException();
		
		Boolean insert = false;
		
		while (!insert) { 
			
			try {
				promotion.setId(this.randomInt.nextTenDigitsRnaodm());
				promotion.setStatus(1);
				promotionORM.setObject(promotion);
				insert = this.promotionORM.addAndSave();
				
				for (PromotionDetailDTO detail : promotion.getPromotionDetails()) {
					
					detail.setPromotionId(promotion.getId());
					this.promotionDetailORM.setObject(detail);
					
					Boolean accessToDetail = checkMenuDetailAccess.
							execute(detail.getMenuDetailId(), promotion.getMenuId());
					
					if (accessToDetail)
						promotionDetailORM.addAndSave();
					
				}

			}catch (NotDuplicatedException ex) { 
				insert = false;
			}
		}	
		return promotion;
	}
	
}
