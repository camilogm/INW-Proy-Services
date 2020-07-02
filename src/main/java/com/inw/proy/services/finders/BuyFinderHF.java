package com.inw.proy.services.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.MakeBuyDTO;
import com.inw.proy.exceptions.NotAllowedException;
import com.inw.proy.services.access.CheckBuyAccessService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("buyFinderHF")
public class BuyFinderHF implements BuyFinderService {

	private ORMApplicationTables<MakeBuyDTO> buyORM;
	
	@Autowired
	@Qualifier("checkBuyAccessHF")
	private CheckBuyAccessService checkBuyAccess;
	
	
	
	public BuyFinderHF() {
	
		buyORM = new ORMApplicationTables<>(MakeBuyDTO.class);
	}
	
	@Override
	public TwoObjectsDTO getBuyer(Integer buyId) throws NullPointerException, SQLException {
		
	
		
		TwoObjectsDTO response = checkBuyAccess.execute(buyId);	
		if (response!=null) {
			
			return response;
		}
		throw new  NotAllowedException();
	}

	
	@Override
	public Object getProductDetails(Integer buyId) throws NullPointerException, SQLException {
		
		String fields[]  = {"products_buy","buyer_id"};
		MakeBuyDTO buy = 
				buyORM.find(buyId,fields);
		
		if (checkBuyAccess.executeBoolean(buyId)) { 
			
			String jsonArray = buy.getProductsBuy().replace("|", "\"");	
			return jsonArray;
		}
		
		throw new NotAllowedException();
		
	}
	
	@Override 
	public Object getPromotionDetails(Integer buyId) throws SQLException {
		
		String fields[] = { "promotions_buy" , "buyer_id"};
		MakeBuyDTO buy = 
				buyORM.find(buyId,fields);
		
		
		if (checkBuyAccess.executeBoolean(buy.getBuyerId())) {
			
			String jsonArray = 
					buy.getPromotionsBuy().replace("|", "\"");
			
			return jsonArray;
		}
		
		
		
		throw new NotAllowedException();
	}
}
