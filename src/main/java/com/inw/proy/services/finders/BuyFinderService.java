package com.inw.proy.services.finders;

import java.sql.SQLException;

import com.inw.proy.DTO.TwoObjectsDTO;

public interface BuyFinderService {

	TwoObjectsDTO getBuyer(Integer buyId) throws NullPointerException, SQLException;

	Object getProductDetails(Integer buyId) throws NullPointerException, SQLException;

	Object getPromotionDetails(Integer buyId) throws SQLException;

}
