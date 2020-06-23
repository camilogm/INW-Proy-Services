package com.inw.proy.services.updates;

import java.sql.SQLException;

import com.inw.proy.DTO.promotion.PromotionUpdateDTO;

public interface PromotionUpdateService {

	Object update(PromotionUpdateDTO promotion) throws NullPointerException, SQLException;

}
