package com.inw.proy.services.finders;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.inw.proy.DTO.menu.MenuDetailDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckActiveMenuService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("menuDetailFinderHF")
public class MenuDetailFinderHF implements MenuDetailFinderService{

	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	@Autowired
	@Qualifier("checkActiveMenuHF")
	private CheckActiveMenuService checkActiveMenuService;
	
	public MenuDetailFinderHF() {
		this.menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
	}
	
	@Override
	public ArrayList<MenuDetailDTO> execute(Integer menuId) throws NullPointerException, SQLException{
		
		
		if (!checkActiveMenuService.execute(menuId))
			throw new  NotAllowedException();
		
		Object[][] conditions = {
				{"menu_id","=",menuId,null}
		};	
		
		return menuDetailORM.findMany(conditions);
	}
	
}
