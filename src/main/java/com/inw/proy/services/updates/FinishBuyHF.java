package com.inw.proy.services.updates;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.buy.BuyDTO;
import com.inw.proy.DTO.buy.BuyProductDTO;
import com.inw.proy.serializations.GetStringfy;
import com.inw.proy.serializations.GetStringfyArrayFromGson;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("finishBuyHF")
public class FinishBuyHF implements FinishBuyService {

	private ORMApplicationTables<BuyDTO> buyORM;
	private GetStringfy getStringfy = new GetStringfyArrayFromGson();
	
	public FinishBuyHF() {
		buyORM = new ORMApplicationTables<>(BuyDTO.class);
	}
	
	
	@Override
	public Object execute(Integer buyId, Object productsDetails, Object promotionsDetails ) throws NullPointerException, SQLException {
		
		BuyDTO buy  = new BuyDTO();
		buy.setId(buyId);
		
		String productBuyStringfy =getStringfy.execute(productsDetails, BuyProductDTO.class);	
		buy.setProductsBuy(productBuyStringfy);
		buyORM.setObject(buy);
		buyORM.updateAndSave();
		return null;
	}
	
}
