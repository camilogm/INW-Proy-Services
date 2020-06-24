package com.inw.proy.services.finders;

import java.sql.SQLException;

public interface PromotionFinderService {

	Object execute(Integer promotionId) throws NullPointerException, SQLException;

}
