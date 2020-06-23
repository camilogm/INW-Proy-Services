package com.inw.proy.services.access;

import java.sql.SQLException;

public interface CheckWriteShopAccess {

	Boolean execute(int shopId) throws NullPointerException, SQLException;

}
