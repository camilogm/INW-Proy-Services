package com.inw.proy.services.access;

import java.sql.SQLException;

public interface CheckMenuDetailAccess {

	Boolean execute(int menuDetailId, int menuId) throws NullPointerException, SQLException;

	Boolean execute(int menuDetailId, int menuId, int shopId) throws NullPointerException, SQLException;

}
