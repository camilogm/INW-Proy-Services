package com.inw.proy.services.inserts;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.promotion.PromotionInsertDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckWriteShopAccess;
import com.inw.proy.utils.PromotionStatus;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotDuplicatedException;
import sv.hawklibrary.com.validators.RandomInt;

@Service
@Qualifier("promotionInsertHF")
public class PromotionInsertHF implements PromotionInsertService {
	
	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;
	
	
	private ORMApplicationTables<PromotionInsertDTO> promotionORM;
	private RandomInt randomInt;
	
	public PromotionInsertHF() {
		
		promotionORM = new ORMApplicationTables<>(PromotionInsertDTO.class);
		randomInt = new RandomInt();
	}
	
	@Override
	public Object execute(PromotionInsertDTO promotion) throws NullPointerException, SQLException {
		
		
		if (!checkWriteShopAccess.execute(promotion.getShopId()))
			throw new NotAllowedException();
		
		try {
			promotion.setId(randomInt.nextTenDigitsRandom());
			promotion.setStatus(PromotionStatus.ACTIVE);
			
			if (promotion.getTotalPrice()==null) { 
				promotion.setTotalPrice(0.0);
				promotion.setStatus(PromotionStatus.MANDATORY_AUDTI);
			}
			
			promotionORM.setObject(promotion);
			this.promotionORM.addAndSave();

		}catch (NotDuplicatedException ex) { 
		}
			
		return promotion;
	}
	
}
