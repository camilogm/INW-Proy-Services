package com.inw.proy.services.finders;

import java.sql.SQLException;

public interface PromotionFinderManyService {

	Object execute(Integer menuId) throws NullPointerException, SQLException;

}
