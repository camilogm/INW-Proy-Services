package com.inw.proy.services.inserts;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDetailDTO;
import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("menuDetailInsertHF")
public class MenuDetailInsertHF implements MenuDetailInsertService {


	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	public MenuDetailInsertHF() {

		menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
		
	}
	
	
	@Override
	public Object insertMany(MenuDetailDTO[] menuDetails, int menuId) throws SQLException {
		
		if (menuDetails!=null)
			for (MenuDetailDTO menuDetail : menuDetails) {
				menuDetail.setMenuId(menuId);
				this.insert(menuDetail);
			}
		return null;
	}
	
	@Override
	public Object insert(MenuDetailDTO menuDetail) throws SQLException {
		
		menuDetailORM.setObject(menuDetail);
		menuDetailORM.addAndSave();
		
		return null;
	}


	
}
