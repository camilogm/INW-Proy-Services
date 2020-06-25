package com.inw.proy.services.inserts;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.BuyProductDTO;
import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.menu.MenuDetailDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;

@Service
@Qualifier("buyProductServiceHF")
public class BuyProductInsertHF implements BuyProductInsertService {

	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	
	public BuyProductInsertHF() {
		this.menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
	}
	
	
	@Override
	public  TwoObjectsDTO insertMany(BuyProductDTO[] details,Integer menuId)
			throws NullPointerException, SQLException { 
		
		TwoObjectsDTO response = new TwoObjectsDTO();
		
		ArrayList<FieldErrorDTO> errors = new ArrayList<>();
		ArrayList<BuyProductDTO> buyProducts = new ArrayList<>();
		
		ArrayList<Integer> menuDetailIds = new ArrayList<>();
		

	
		if (details!=null)
			for (BuyProductDTO detail : details) {
				
				if (!menuDetailIds.contains(detail.getMenuDetailId())) {
				
					Object detailResponse = this.insert(detail, menuId);
					
					String className = detailResponse==null ? "" 
							: detailResponse.getClass().getSimpleName();
					if (className.equals("FieldErrorDTO")) {
						errors.add( (FieldErrorDTO) detailResponse );
					}
					if(className.equals("BuyProductDTO")) {

						menuDetailIds.add(detail.getMenuDetailId());
						buyProducts.add((BuyProductDTO) detailResponse);
					}
				}
			}
		
		
		if (errors.size()!=0)
			response.setObjectTwo(errors);
		if (buyProducts.size()!=0)
			response.setObjectOne(buyProducts);
		
		return response;
	}
	
	@Override
	public Object insert (BuyProductDTO detail, Integer menuId) 
			throws NullPointerException, SQLException { 
		
		
		try {
			MenuDetailDTO detailMenu = menuDetailORM.find(detail.getMenuDetailId());
			
			if (detailMenu.getMenuId()==menuId) {
				
				detail.setProductName(detailMenu.getProductName());
				detail.setMementoPrice(detailMenu.getUnitaryPrice());
				return detail;
			}
			
		}catch (NotFoundException ex) { 
			
		}
		
		return null;
	}
	
}
