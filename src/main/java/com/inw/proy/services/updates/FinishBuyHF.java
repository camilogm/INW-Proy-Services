package com.inw.proy.services.updates;


import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.buy.BuyDTO;
import com.inw.proy.DTO.buy.BuyProductDTO;
import com.inw.proy.DTO.buy.BuyPromotionDTO;
import com.inw.proy.DTO.buy.MakeBuyDTO;
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
	public Object execute(Integer buyId, ArrayList<BuyProductDTO> productsDetails,
		 ArrayList<BuyPromotionDTO> promotionsDetails ) throws NullPointerException, SQLException {
		
		MakeBuyDTO buy  = new MakeBuyDTO();
		buy.setId(buyId);
		Double totalPrice = 0.0;
			
		if (productsDetails!=null)
			for (BuyProductDTO product : productsDetails) { 	
				totalPrice += product.getMementoPrice() * product.getQuantity();
			}
		
		if (promotionsDetails!=null)
			for (BuyPromotionDTO promotion : promotionsDetails) {
				totalPrice += promotion.getMementoPrice() * promotion.getQuantity();
			}
		
		
		String productBuyStringfy = getStringfy.execute(productsDetails, BuyProductDTO.class)
				.replace("\"", "|");	
		String promotionBuyStringfy = getStringfy.execute(promotionsDetails, BuyPromotionDTO.class)
				.replace("\"", "|");
		
		buy.setProductsBuy(productBuyStringfy);
		buy.setPromotionsBuy(promotionBuyStringfy);
		buy.setTotalPrice(totalPrice);
		buyORM.setObject(buy);
		 
		if (buyORM.updateAndSave()) {
			BuyProductDTO[] products = productsDetails==null ? null :  productsDetails
					.toArray(new BuyProductDTO[productsDetails.size()]);
			
			
			BuyPromotionDTO[] promotions = promotionsDetails==null ? null : promotionsDetails
					.toArray(new BuyPromotionDTO[promotionsDetails.size()] );	
					
			buy.setProducts(products);
			buy.setPromotions(promotions);
			buy.setProductsBuy(null);
			buy.setPromotionsBuy(null);
			
		}
		
		return buy;
	}
	
}
