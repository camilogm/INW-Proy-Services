package com.inw.proy.services.access;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.DTO.menu.MenuDetailDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;

@Service
@Qualifier("checkMenuDetailHF")
public class CheckMenuDetaillHF implements CheckMenuDetailAccess {

	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	private ORMApplicationTables<MenuDTO> menuORM;
	
	public CheckMenuDetaillHF() { 
		
		this.menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
		this.menuORM = new ORMApplicationTables<>(MenuDTO.class);
	}
	
	@Override
	public Boolean execute(int menuDetailId,int menuId) throws NullPointerException, SQLException {
	
		try { 
			
			int menuIdFound = menuDetailORM.find(menuDetailId).getMenuId();
			
			if (menuIdFound == menuId)
				return true;
			
		}catch (NotFoundException ex) { 
			
		}
		return false;
	}
	
	@Override
	public Boolean execute(int menuDetailId,int menuId, int shopId) throws NullPointerException, SQLException {
	
		try { 
			
			int menuIdFound = menuDetailORM.find(menuDetailId).getMenuId();
			int shopIdFound = menuORM.find(menuId).getShopId(); 
			
			
			if (menuIdFound == menuId && shopIdFound==shopId)
				return true;
			
		}catch (NotFoundException ex) { 
			
		}
		return false;
	}
}
