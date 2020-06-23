package com.inw.proy.services.updates;

import java.sql.SQLException;

import com.inw.proy.DTO.menu.MenuUpdateDTO;

public interface MenuUpdateService {

	Object execute(MenuUpdateDTO menuUpdateDTO) throws SQLException;

}
