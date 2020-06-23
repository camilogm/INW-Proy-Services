package com.inw.proy.services.deletes;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.menu.DeleteMenuDetailDTO;
import com.inw.proy.DTO.menu.MenuDetailDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;
import com.inw.proy.services.access.CheckMenuDetailAccess;
import com.inw.proy.services.access.CheckWriteShopAccess;
import com.inw.proy.services.updates.PromotionChangeStatusService;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("deleteMenuDetailHF")
public class DeleteMenuDetailHF implements DeleteMenuDetailService {

	private ORMApplicationTables<MenuDetailDTO> menuDetailORM;
	private ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	
	@Autowired
	@Qualifier("checkWriteShopHF")
	private CheckWriteShopAccess checkWriteShopAccess;
	
	@Autowired
	@Qualifier("promotionChangeStatusHF")
	private PromotionChangeStatusService promotionUpdateService;
	
	@Autowired
	@Qualifier("checkMenuDetailHF")
	private CheckMenuDetailAccess checkMenuDetailAccess;
	
	
	public DeleteMenuDetailHF() {
		menuDetailORM = new ORMApplicationTables<>(MenuDetailDTO.class);	
		promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
	}
	
	@Override
	public Object deleteMany(DeleteMenuDetailDTO[] details) throws NullPointerException, SQLException {
		
		if (details!=null)
			for (DeleteMenuDetailDTO detail : details) {
				this.delete(detail);
			}
		return null;
	}
	
	@Override
	public Object delete(DeleteMenuDetailDTO detail ) throws NullPointerException, SQLException {
	
		Boolean checkShop = checkWriteShopAccess.execute(detail.getShopId());
		Boolean checkMenuDetail = 
				checkMenuDetailAccess
				.execute(detail.getMenuDetailId(), detail.getMenuId(),
										detail.getShopId());
		
		if (checkShop && checkMenuDetail) {
			
			MenuDetailDTO menuDetail = new MenuDetailDTO();
			menuDetail.setId(detail.getMenuDetailId());
			menuDetailORM.setObject(menuDetail);
			
			promotionUpdateService
			.auditoPromotionStatus(detail.getMenuDetailId(), detail.getMenuId());
			
			Object[][] conditions = {{"menu_detail_id","=",detail.getMenuDetailId(),null}};
			promotionDetailORM.deleteAndSave(conditions);
			menuDetailORM.deleteAndSave();	
		}
		
		return null;
	}
	
	
}
