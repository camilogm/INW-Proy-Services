package com.inw.proy.services.updates;

import java.sql.SQLException;

import com.inw.proy.DTO.promotion.PromotionDetailDTO;

public interface PromotionDetailUpdateService {

	Object updateMany(PromotionDetailDTO[] details,Integer menuId,Integer promotionId) throws SQLException;

	Object udpdate(PromotionDetailDTO detail,Integer menuId,Integer promotionId) throws SQLException;

	
}
