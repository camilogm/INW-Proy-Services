package com.inw.proy.services.inserts;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.BuyPromotionDTO;
import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.menu.MenuDetailDTO;
import com.inw.proy.DTO.promotion.PromotionDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;

@Service
@Qualifier("buyPromotionInsertHF")
public class BuyPromotionInsertHF implements BuyPromotionInsertService {


	private ORMApplicationTables<PromotionDTO> promotionORM;
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	public BuyPromotionInsertHF() {
		
		this.promotionORM = new ORMApplicationTables<>(PromotionDTO.class);
		this.promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
		this.menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
	}
	
	@Override
	public TwoObjectsDTO insertMany(BuyPromotionDTO[] details,Integer menuId) throws NullPointerException, SQLException { 
		
		TwoObjectsDTO response = new TwoObjectsDTO();
		ArrayList<FieldErrorDTO> errors = new ArrayList<>();
		ArrayList<BuyPromotionDTO> promotions = new ArrayList<>();
		ArrayList<Integer> registeredIds = new ArrayList<>();
		
		if (details!=null)
			for (BuyPromotionDTO detail : details) {
				
				if (!registeredIds.contains(detail.getPromotionId())) {
					
					Object insertResponse = this.insert(detail, menuId);
					Class<? extends Object> classObject = insertResponse.getClass();
					
					if (classObject == BuyPromotionDTO.class) { 
						
						registeredIds.add(detail.getPromotionId());
						promotions.add( (BuyPromotionDTO) insertResponse );
					
					}
					if (classObject == FieldErrorDTO.class) {
						errors.add((FieldErrorDTO) insertResponse );	
					}	
				}
				
			}
		
		if (promotions.size()!=0)
			response.setObjectOne(promotions);
		if (errors.size()!=0)
			response.setObjectTwo(errors);
		
		return response;
	}
	
	@Override
	public Object insert(BuyPromotionDTO detail, Integer menuId) throws NullPointerException, SQLException { 
		
		try { 
			
			PromotionDTO promotion = promotionORM.find(detail.getPromotionId());
			if (promotion.getMenuId()!=menuId)
				return null;
			
			
			
			String[] fields = {"quantity","menu_detail_id"};
			
			Object[][] conditions = {
					{"promotion_id","=",promotion.getId(),null}
			};
			
			ArrayList<PromotionDetailDTO> details = 
					promotionDetailORM.findMany(conditions,fields);
			
			if (details!=null ) {
				details.forEach(detailProm -> {
					String productName = "NaN";
					try {
						productName = menuDetailORM.find(detailProm.getMenuDetailId()).getProductName();
					} catch ( NotFoundException | NullPointerException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					detailProm.setName(productName);
				});
			}
			
			BuyPromotionDTO promotionDetail = 
					new BuyPromotionDTO(promotion.getId(), 
										promotion.getName(),
										detail.getQuantity(), 
										promotion.getTotalPrice(), details);
			
			return promotionDetail;
			
		}catch (NotFoundException ex) {
			
		}
		
		return null;
	}
}
