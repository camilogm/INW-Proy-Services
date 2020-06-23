package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.promotion.PromotionDetailDTO;

public interface PromotionDetailInsertService {

	Object insertMany(PromotionDetailDTO[] details, Integer promotionId, Integer menuId)
			throws NullPointerException, SQLException;

	Object insert(PromotionDetailDTO detail, Integer promotionId, Integer menuId)
			throws NullPointerException, SQLException;

}
