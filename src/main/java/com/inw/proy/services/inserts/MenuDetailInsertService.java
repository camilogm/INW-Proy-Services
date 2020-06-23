package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.menu.MenuDetailDTO;

public interface MenuDetailInsertService {

	Object insert(MenuDetailDTO menuDetail) throws SQLException;

	Object insertMany(MenuDetailDTO[] menuDetails, int menuId) throws SQLException;

}
