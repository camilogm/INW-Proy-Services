package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.buy.BuyDTO;
import com.inw.proy.DTO.buy.MakeBuyDTO;

public interface BuyInsertService {

	BuyDTO execute(MakeBuyDTO buy) throws SQLException;

}
