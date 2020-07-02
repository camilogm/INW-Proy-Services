package com.inw.proy.services.finders;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.ShopDTO;

import sv.hawklibrary.com.ORM.ConditionsStructure;
import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("shopFinderManyHF")
public class ShopFinderManyHF implements ShopFinderManyService {

	
	private ORMApplicationTables<ShopDTO> shopORM;
	
	public ShopFinderManyHF() {
		this.shopORM = new ORMApplicationTables<>(ShopDTO.class);
	}
	
	@Override
	public ArrayList<ShopDTO> execute(ConditionsStructure conditions){ 
		
		return shopORM.findMany(conditions);
	}
	
}
