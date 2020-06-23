package com.inw.proy.services.updates;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.promotion.PromotionInsertDTO;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;
import com.inw.proy.utils.PromotionStatus;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("promotionChangeStatusHF")
public class PromotionChangeStatusHF implements PromotionChangeStatusService {

	ORMApplicationTables<PromotionInsertDTO> promotionORM;
	ORMApplicationTables<PromotionDetailDTO> promotionDetailORM;
	
	public PromotionChangeStatusHF() {
		promotionORM = new ORMApplicationTables<>(PromotionInsertDTO.class);
		promotionDetailORM = new ORMApplicationTables<>(PromotionDetailDTO.class);
	}

	
	@Override
	public Boolean auditoPromotionStatus(Integer detailMenuId, Integer menuId) throws NullPointerException, SQLException {

		Object[][] conditions = {{"menu_id","=",menuId,null}};
		ArrayList<PromotionInsertDTO> promotions = promotionORM.findMany(conditions);
		
		if (promotions != null)
			promotions.forEach(promotion -> {

				if (promotion.getStatus() == PromotionStatus.ACTIVE) {

					Object[][] conditionsDetail = { { "promotion_id", "=", promotion.getId(), null } };
					ArrayList<PromotionDetailDTO> details = promotionDetailORM.findMany(conditionsDetail);

					if (details!=null)
						for (PromotionDetailDTO detail : details) {
							
							
							if (Objects.equals(detail.getMenuDetailId(), detailMenuId)) {
	
								promotion.setStatus(PromotionStatus.AUDIT);
								promotionORM.setObject(promotion);
								try {
									promotionORM.updateAndSave();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
						}
				}
			});		
		
		return false;
	}
}
