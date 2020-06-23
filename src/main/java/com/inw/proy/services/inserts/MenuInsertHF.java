package com.inw.proy.services.inserts;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.inw.proy.DTO.menu.MenuInsertDTO;
import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckWriteShopAccess;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.RandomString;


@Service
@Qualifier("menuInsertHF")
public class MenuInsertHF implements MenuInsertService {
 
	private RandomString randomString;
	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;
	

	private ORMApplicationTables<MenuDTO> menuORM;
	
	
	public MenuInsertHF() {
		randomString = new RandomString();
		menuORM = new ORMApplicationTables<>(MenuDTO.class);
	}
	

	@Override
	public Object execute(MenuInsertDTO menu) throws SQLException {
		
		if(!checkWriteShopAccess.execute(menu.getShopId()))
			throw new NotAllowedException();
		
		MenuDTO menuModel = menu.getMenu();
		menuModel.setShopId(menu.getShopId());
		menuModel.setCode(randomString.execute(12));
		
		menuORM.setObject(menuModel);
		menuORM.addAndSave();

		
		Object[][] conditions = {{"code","=",menuModel.getCode(),null}};
		MenuDTO menuFind = menuORM.find(conditions);
		
		return menuFind;
	}

}
