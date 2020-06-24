package com.inw.proy.services.deletes;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.DTO.promotion.PromotionDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckWriteShopAccess;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("promotionDeleteHF")
public class PromotionDeleteHF implements PromotionDeleteService {

	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;
	
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	private ORMApplicationTables<PromotionDTO> promotionORM;
	private ORMApplicationTables<MenuDTO> menuORM;
	
	public PromotionDeleteHF() {
		this.promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
		this.promotionORM = new ORMApplicationTables<>(PromotionDTO.class);
		this.menuORM = new ORMApplicationTables<>(MenuDTO.class);
	}
	
	@Override
	public Object execute(Integer promotionId) throws NullPointerException, SQLException {
		
		PromotionDTO promotion = promotionORM.find(promotionId);
		MenuDTO menu = menuORM.find(promotion.getMenuId());
		
		if (!checkWriteShopAccess.execute(
				menu.getId(),menu.getShopId()))
			throw new NotAllowedException();
		
		Object[][] conditions = {
				{"promotion_id","=",promotionId,null}
		};
		
		promotionORM.setObject(promotion);
		promotionDetailORM.deleteAndSave(conditions);
		promotionORM.deleteAndSave();
		return promotion;
	}
}
