package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.BuyProductDTO;

public interface BuyProductInsertService {

	TwoObjectsDTO insertMany(BuyProductDTO[] details, Integer menuId) throws NullPointerException, SQLException;

	Object insert(BuyProductDTO detail, Integer menuId) throws NullPointerException, SQLException;

}
