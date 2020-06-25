package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.BuyPromotionDTO;

public interface BuyPromotionInsertService {

	TwoObjectsDTO insertMany(BuyPromotionDTO[] details, Integer menuId) throws NullPointerException, SQLException;

	Object insert(BuyPromotionDTO detail, Integer menuId) throws NullPointerException, SQLException;

}
