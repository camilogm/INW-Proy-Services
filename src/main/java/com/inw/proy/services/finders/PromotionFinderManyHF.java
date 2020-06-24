package com.inw.proy.services.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.promotion.PromotionDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckActiveMenuService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("promotionFinderManyHF")
public class PromotionFinderManyHF implements PromotionFinderManyService {

	private ORMApplicationTables<PromotionDTO> promotionORM;
	
	@Autowired
	@Qualifier("checkActiveMenuHF")
	private CheckActiveMenuService checkActiveMenuService;
	
	
	public PromotionFinderManyHF() {
		promotionORM = new ORMApplicationTables<>(PromotionDTO.class);
	}
	
	@Override
	public Object execute(Integer menuId) throws NullPointerException, SQLException {
		
		if (!checkActiveMenuService.execute(menuId))
			throw new NotAllowedException();
		
		Object[][] conditions = { 
				{"menu_id","=",menuId,null}
		};	
		return promotionORM.findMany(conditions);
		
	}
	
}
