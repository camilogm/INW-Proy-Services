package com.inw.proy.services.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.ShopDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("shopFinderHF")
public class ShopFinderHF implements ShopFinderService {

	private ORMApplicationTables<ShopDTO> shopORM;
	
	public ShopFinderHF() {
		shopORM = new ORMApplicationTables<>(ShopDTO.class);
	}
	
	
	@Override
	public Object execute(Integer id) throws NullPointerException, SQLException {
	
		ShopDTO shop = shopORM.find(id);
		return shop;
	
	}

	
	
}
