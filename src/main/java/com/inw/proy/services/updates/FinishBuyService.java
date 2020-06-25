package com.inw.proy.services.updates;

import java.sql.SQLException;
import java.util.ArrayList;

import com.inw.proy.DTO.buy.BuyProductDTO;
import com.inw.proy.DTO.buy.BuyPromotionDTO;

public interface FinishBuyService {

	Object execute(Integer buyId,
			ArrayList<BuyProductDTO> productsDetails, 
			ArrayList<BuyPromotionDTO> promotionsDetails) throws NullPointerException, SQLException;

}
