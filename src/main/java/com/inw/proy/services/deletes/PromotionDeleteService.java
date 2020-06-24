package com.inw.proy.services.deletes;

import java.sql.SQLException;

public interface PromotionDeleteService {

	Object execute(Integer promotionId) throws NullPointerException, SQLException;

}
