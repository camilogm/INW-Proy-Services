package com.inw.proy.services.finders;

import java.sql.SQLException;
import java.util.ArrayList;

import com.inw.proy.DTO.menu.MenuDetailDTO;

public interface MenuDetailFinderService {

	ArrayList<MenuDetailDTO> execute(Integer menuId) throws NullPointerException, SQLException;

}
