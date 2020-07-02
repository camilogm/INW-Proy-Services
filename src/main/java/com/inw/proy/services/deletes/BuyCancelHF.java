package com.inw.proy.services.deletes;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.buy.BuyDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckBuyAccessService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("buyCancelHF")
public class BuyCancelHF implements BuyCancelService {

	private ORMApplicationTables<BuyDTO> buyORM;
	
	@Autowired
	@Qualifier("checkBuyAccessHF")
	private CheckBuyAccessService checkBuyAccessService;
	
	public BuyCancelHF() {
		buyORM = new ORMApplicationTables<>(BuyDTO.class);
	}
	
	@Override
	public Boolean execute (Integer buyId) throws NullPointerException, SQLException {
		
		BuyDTO buy = buyORM.find(buyId);
		
		if (checkBuyAccessService.executeBooleanDelete(buy.getBuyerId())) {
			
			buyORM.setObject(buy);
			buyORM.deleteAndSave();
			return true;
		}
		
		throw new NotAllowedException();
	}
	
	
	
}
