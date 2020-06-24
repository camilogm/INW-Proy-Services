package com.inw.proy.services.access;

import java.sql.SQLException;

public interface CheckActiveMenuService {

	Boolean execute(Integer menuId) throws NullPointerException, SQLException;

}
