package com.inw.proy.services.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("menuFinderHF")
public class MenuFinderHF implements MenuFinderService {

	private ORMApplicationTables<MenuDTO> menuORM;
	
	public MenuFinderHF() {
		this.menuORM = new ORMApplicationTables<>(MenuDTO.class);
	}
	
	@Override
	public Object execute(Integer shopId) throws NullPointerException, SQLException {
		
		Object[][] conditions = {
				{"shop_id","=",shopId,"AND" },
				{"active","=","1",null}
		};
		
		MenuDTO menu = menuORM.find(conditions);
		return menu;	
	}
	
}
