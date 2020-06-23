package com.inw.proy.services.access;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.ShopDTO;
import com.inw.proy.utils.UserDetailsLogged;

import sv.hawklibrary.com.ORM.ORMApplicationTables;


@Service
@Qualifier("checkWriteShopHF")
public class CheckWriteShopHF implements CheckWriteShopAccess {
	
	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@Override
	public Boolean execute(int shopId) throws NullPointerException, SQLException {
		
		ORMApplicationTables<ShopDTO> shopORM = new ORMApplicationTables<>(ShopDTO.class);
		Integer userId = shopORM.find(shopId).getUserId();
		if (userId!=userDetails.getUser().getId())
			return false;
		else
			return true;
		
	}
	
}
