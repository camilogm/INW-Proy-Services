package com.inw.proy.services.errors;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.buy.BuyProductDTO;
import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.menu.MenuDetailDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;

@Service
@Qualifier("productBuyCheckHF")
public class ProductBuyCheckHF implements ProductBuyCheckService {

	private ORMApplicationTables<BuyProductDTO> buyProductORM;
	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	public ProductBuyCheckHF() {
		buyProductORM = new ORMApplicationTables<>(BuyProductDTO.class);
		menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
	}
	
	@Override
	public FieldErrorDTO execute(Integer menuDetailId, Integer buyId) {
		
		String productName = "NaN";
		try { 
			Object[][] conditions = { 
					{"buy_id","=",buyId,"AND"},
					{"menu_detail_id","=",menuDetailId,null}
			};
			
			buyProductORM.find(conditions);
			productName = menuDetailORM.find(menuDetailId).getProductName();
			
		}catch (NotFoundException ex) {
			return null;
			
		}catch (SQLException ex) {	
		
		}
		FieldErrorDTO error = 
				new FieldErrorDTO("detalle menu"
				, "El producto "+productName +" ya ha sido registrado a la compra");
		
		return error;
		
	}
	
}
