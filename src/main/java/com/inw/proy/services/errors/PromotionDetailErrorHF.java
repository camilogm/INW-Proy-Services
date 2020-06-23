package com.inw.proy.services.errors;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.errors.FieldErrorDTO;
import com.inw.proy.DTO.menu.MenuDetailDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;
import sv.hawklibrary.com.validators.NotFoundException;


@Service
@Qualifier("promotionDetailErrorHF")
public class PromotionDetailErrorHF implements PromotionDetailErrorService {

	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
		
	public PromotionDetailErrorHF() {	
		menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);
		promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
	}
	
	@Override
	public FieldErrorDTO getFieldError(int menuDetailId, String field ) {
		
		String productName = " NaN";
		try {
			productName = menuDetailORM.find(menuDetailId).getProductName();
		} catch (NullPointerException | SQLException e) {
		}
		String message = "Detalle de promoción inválido para : " + productName ;	
		FieldErrorDTO error = new FieldErrorDTO(field, message);						
		return error;	
	}
	
	@Override
	public FieldErrorDTO alredyRegistredDetail(int menuDetailId, int promotionId)  {
	
		Object[][] conditions = {
				{"menu_detail_id","=",menuDetailId,"AND"},
				{"promotion_id","=",promotionId,null}
		};

		try { 
			
			promotionDetailORM.find(conditions);
			String productName = menuDetailORM.find(menuDetailId).getProductName();
			String message = "El producto "+productName + " ya ha sido registrado para esta promoción";
			String field = "id";
			FieldErrorDTO error = new FieldErrorDTO(field,message);
			return error;
		}
		catch (NotFoundException ex ) {
			return null;
			
		}catch (SQLException ex) {
			FieldErrorDTO error = new FieldErrorDTO("error","error");
			return error;
		}
	}
	
	@Override
	public FieldErrorDTO errorDeleting(int menuDetailId){ 
		try { 
			
			String productName = menuDetailORM.find(menuDetailId).getProductName();
			String message = "El producto "+productName + " no se pudo eliminar";
			String field = "id";
			FieldErrorDTO error = new FieldErrorDTO(field,message);
			return error;
		}
		catch (NotFoundException | SQLException | NullPointerException e) {
	
			FieldErrorDTO error = new FieldErrorDTO("error","error");
			return error;
		}
	}
	
}
