package com.inw.proy.services.access;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.ShopDTO;
import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.MakeBuyDTO;
import com.inw.proy.DTO.logged.UserDTO;
import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.utils.UserDetailsLogged;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("checkBuyAccessHF")
public class CheckBuyAccessHF implements CheckBuyAccessService {

	
	@Autowired
	private UserDetailsLogged userDetails;
	private ORMApplicationTables<MakeBuyDTO> buyORM;
	private ORMApplicationTables<ShopDTO> shopORM;
	private ORMApplicationTables<MenuDTO> menuORM;
	private ORMApplicationTables<UserDTO> userORM;
	
	public CheckBuyAccessHF() {
		
		this.buyORM = new ORMApplicationTables<>(MakeBuyDTO.class);
		this.shopORM = new ORMApplicationTables<>(ShopDTO.class);
		this.menuORM = new ORMApplicationTables<>(MenuDTO.class);
		this.userORM = new ORMApplicationTables<>(UserDTO.class);
	}
	
	
	@Override
	public TwoObjectsDTO execute(Integer buyId) throws NullPointerException, SQLException { 
		
		MakeBuyDTO buy = this.getBuy(buyId);
		
		System.out.println(userDetails.getUser().getId());
		
		if (userDetails.getUser().getId() == buy.getBuyerId() ) {
			
			return new TwoObjectsDTO(userDetails.getUser(),buy);
		}else {
			
			Integer shopId = menuORM.find(buy.getMenuId()).getShopId();
			Integer sellerId = shopORM.find(shopId).getUserId();
			
			if (userDetails.getUser().getId() == sellerId) { 
				
				UserDTO client = userORM.find(buy.getBuyerId());
				return new TwoObjectsDTO(client,buy);
			}			
		}
		
		return null;
	}
	
	@Override
	public Boolean executeBoolean(Integer buyId) throws NullPointerException, SQLException { 
		
		TwoObjectsDTO response = this.execute(buyId);
		
		if (response != null)
			return true;
		
		return false;	
	}
	
	private MakeBuyDTO getBuy(Integer buyId) throws NullPointerException, SQLException { 
	
		String fields[] = { "id","buyer_id", "menu_id","total_price","date","delivery_service" };
		
		MakeBuyDTO buy = 
				buyORM.find(buyId,fields);
		
		return buy;
	}

	@Override
	public Boolean executeBooleanDelete(Integer buyerId) {
		
		if (userDetails.getUser().getId() == buyerId) { 
			return true;
		}
		
		return false;
	}
}
