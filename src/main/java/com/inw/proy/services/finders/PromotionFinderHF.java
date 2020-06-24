package com.inw.proy.services.finders;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDetailDTO;
import com.inw.proy.DTO.promotion.PromotionDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckActiveMenuService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("promotionFinderHF")
public class PromotionFinderHF  implements PromotionFinderService{

	private ORMApplicationTables<PromotionDTO> promotionORM;
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	@Autowired
	@Qualifier("checkActiveMenuHF")
	private CheckActiveMenuService checkActiveMenuService;
	
	public PromotionFinderHF() {
	
		this.promotionORM = new ORMApplicationTables<>(PromotionDTO.class);
		this.promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
		this.menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
	}
	
	@Override
	public Object execute(Integer promotionId) throws NullPointerException, SQLException {
		
		PromotionDTO promotion = promotionORM.find(promotionId);
		
		if (!checkActiveMenuService.execute(promotion.getMenuId()))
			throw new NotAllowedException();
		
		Object[][] conditions = { 
				{"promotion_id","=",promotionId,null}
		};
		
		ArrayList<PromotionDetailDTO> details = promotionDetailORM.findMany(conditions);
		details.forEach(detail -> {
			
			String productName = "NaN";
			try {
				productName = menuDetailORM.find(detail.getMenuDetailId()).getProductName();
			} catch (NullPointerException | SQLException e) {
			}
			detail.setName(productName);			
		});
		
		return details;
	}

}
