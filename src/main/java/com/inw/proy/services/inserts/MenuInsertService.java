package com.inw.proy.services.inserts;

import java.sql.SQLException;

import com.inw.proy.DTO.menu.MenuInsertDTO;

public interface MenuInsertService {

	Object execute(MenuInsertDTO menu) throws SQLException;

}
