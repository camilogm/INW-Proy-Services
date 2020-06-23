package com.inw.proy.services.access;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.ShopDTO;
import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.utils.UserDetailsLogged;

import sv.hawklibrary.com.ORM.ORMApplicationTables;


@Service
@Qualifier("checkWriteShopHF")
public class CheckWriteShopHF implements CheckWriteShopAccess {
	
	
	@Autowired
	private UserDetailsLogged userDetails;
	
	private ORMApplicationTables<ShopDTO> shopORM;
	private ORMApplicationTables<MenuDTO> menuORM;
	
	public CheckWriteShopHF() {
	 	shopORM = new ORMApplicationTables<>(ShopDTO.class);
	 	menuORM = new ORMApplicationTables<>(MenuDTO.class);
	}
		
	/**
	 * 
	 */
	@Override
	public Boolean execute(int shopId) throws NullPointerException, SQLException {
		
		Integer userId = shopORM.find(shopId).getUserId();
		if (userId!=userDetails.getUser().getId())
			return false;
		else
			return true;
		
	}
	
	

	@Override
	public Boolean execute(int menuId, int shopId) throws NullPointerException, SQLException {
		
		Integer userId = shopORM.find(shopId).getUserId();
		Integer shopIdFound = menuORM.find(menuId).getShopId();	
		
		if (userId==userDetails.getUser().getId()
				&& shopId == shopIdFound)
			return true;
		else
			return false;
		
	}
	
}
