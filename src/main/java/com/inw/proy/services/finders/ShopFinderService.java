package com.inw.proy.services.finders;

import java.sql.SQLException;

public interface ShopFinderService {

	Object execute(Integer id) throws NullPointerException, SQLException;
}
