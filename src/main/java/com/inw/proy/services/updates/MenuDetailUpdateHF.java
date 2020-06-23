package com.inw.proy.services.updates;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDetailDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;

@Service
@Qualifier("menuDetailUpdateHF")
public class MenuDetailUpdateHF implements MenuDetailUpdateService {

	ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	@Autowired
	@Qualifier("promotionUpdateHF")
	private PromotionUpdateService promotionUpdateService;
	
	public MenuDetailUpdateHF() {
		menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
	}
	
	@Override
	public Object updateMany(MenuDetailDTO[] details,Integer menuId) throws SQLException {
		
		
		if (details!=null)
			for (MenuDetailDTO detail : details) {
				this.update(detail,menuId);
			}
		return null;
	}
	
	@Override	
	public Object update(MenuDetailDTO detail,Integer menuId) throws SQLException {

		
		try { 
			MenuDetailDTO menuDetail = menuDetailORM.find(detail.getId());	
			if (detail.getMenuId()==menuDetail.getMenuId()
					&& detail.getMenuId() == menuId) {
				
				menuDetailORM.setObject(detail);
				menuDetailORM.updateAndSave();
				
			}
			promotionUpdateService.
						auditoPromotionStatus(detail.getId(), menuId);
	
			
			
		}catch (NotFoundException ex) { 
			
		}
		return null;
	}

}
