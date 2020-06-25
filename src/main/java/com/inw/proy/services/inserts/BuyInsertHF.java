package com.inw.proy.services.inserts;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.buy.BuyDTO;
import com.inw.proy.DTO.buy.MakeBuyDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckActiveMenuService;
import com.inw.proy.utils.UserDetailsLogged;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.RandomInt;

@Service
@Qualifier("buyInsertHF")
public class BuyInsertHF implements BuyInsertService {

	private ORMApplicationTables<BuyDTO> buyORM;
	private RandomInt random;
	@Autowired
	private UserDetailsLogged userDetails;
	@Autowired
	@Qualifier("checkActiveMenuHF")
	private CheckActiveMenuService checkActiveMenuService;
	
	public BuyInsertHF() {
		random = new RandomInt();	
		buyORM = new ORMApplicationTables<>(BuyDTO.class);
	}
	
	@Override
	public BuyDTO execute(MakeBuyDTO buy) throws SQLException { 
		
		if (!checkActiveMenuService.execute(buy.getMenuId()))
			throw new NotAllowedException();
				
		
		buy.setId(random.nextTenDigitsRandom());
		buy.setBuyerId(userDetails.getUser().getId());
		buy.setDate(null);
		buy.setProductsBuy(null);
		buy.setPromotionsBuy(null);
		//check localization mode
		BuyDTO buyInsert = buy;
		
		buyORM.setObject(buyInsert);
		buyORM.addAndSave();	
		return buy;
	}
	
	
	
}
