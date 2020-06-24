package com.inw.proy.services.access;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("checkActiveMenuHF")
public class CheckActiveMenuHF implements CheckActiveMenuService {

	private ORMApplicationTables<MenuDTO> menuORM;
	
	public CheckActiveMenuHF() {
		this.menuORM = new ORMApplicationTables<>(MenuDTO.class);
	}
	
	@Override
	public Boolean execute(Integer menuId) throws NullPointerException, SQLException {
		
		MenuDTO menu = menuORM.find(menuId);
		
		if (menu.getActive()==1)
			return true;
		
		return false;	
	}
}
