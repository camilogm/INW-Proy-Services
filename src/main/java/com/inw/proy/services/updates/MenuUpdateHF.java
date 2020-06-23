package com.inw.proy.services.updates;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.DTO.menu.MenuUpdateDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckWriteShopAccess;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("menuUpdateHF")
public class MenuUpdateHF implements MenuUpdateService {

	private ORMApplicationTables<MenuDTO> menuORM ;
	
	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;
	
	public MenuUpdateHF() {
		menuORM = new ORMApplicationTables<>(MenuDTO.class);
		
	}
	
	
	@Override
	public Object execute(MenuUpdateDTO menuUpdateDTO) throws SQLException {
	
		MenuDTO menuOriginal = menuORM.find(menuUpdateDTO.getId());
		Integer shopIdFound = menuOriginal.getShopId();
		Boolean checkAccessShop = checkWriteShopAccess.execute(menuUpdateDTO.getShopId());
		Boolean checkShopId = (menuUpdateDTO.getShopId() == shopIdFound) ? true : false;
			
		if (!checkShopId || !checkAccessShop)
			throw new NotAllowedException();
		
		
		MenuDTO menuUpdate = menuUpdateDTO.getMenu();
		int active = menuUpdateDTO.getActive()==1 || menuUpdate.getActive()==0 ? menuUpdate.getActive() : 
					menuOriginal.getActive();
		
		menuUpdate.setCode(menuOriginal.getCode());
		menuUpdate.setActive(active);
		
		menuORM.setObject(menuUpdate);
		
		menuORM.updateAndSave();	
		return menuUpdate;
	}
	
}
