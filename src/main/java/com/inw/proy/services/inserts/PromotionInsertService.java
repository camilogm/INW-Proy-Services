package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.promotion.PromotionInsertDTO;

public interface PromotionInsertService {

	Object execute(PromotionInsertDTO promotion) throws NullPointerException, SQLException;

}
