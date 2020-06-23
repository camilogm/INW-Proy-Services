package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.menu.PromotionDTO;

public interface PromotionInsertService {

	Object execute(PromotionDTO promotion) throws NullPointerException, SQLException;

}
