package com.inw.proy.services.updates;

import java.sql.SQLException;

import com.inw.proy.DTO.menu.MenuDetailDTO;

public interface MenuDetailUpdateService {

	Object updateMany(MenuDetailDTO[] details, Integer integer) throws SQLException;

	Object update(MenuDetailDTO detail, Integer menuId) throws SQLException;

}
