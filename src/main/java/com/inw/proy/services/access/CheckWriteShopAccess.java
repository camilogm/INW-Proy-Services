package com.inw.proy.services.access;

import java.sql.SQLException;

public interface CheckWriteShopAccess {

	/**
	 * 
	 * @param shopId
	 * @return if the user has access to edit shop
	 * @throws NullPointerException
	 * @throws SQLException
	 */
	Boolean execute(int shopId) throws NullPointerException, SQLException;

	/**
	 * 
	 * @param menuId
	 * @param shopId
	 * @return check if the user has access to edit shop/menu
	 * @throws NullPointerException
	 * @throws SQLException
	 */
	Boolean execute(int menuId, int shopId) throws NullPointerException, SQLException;

}
