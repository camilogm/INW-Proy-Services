package com.inw.proy.services.finders;

import java.sql.SQLException;

public interface MenuFinderService {

	Object execute(Integer shopId) throws NullPointerException, SQLException;

	
}
