package com.inw.proy.services.finders;

import java.sql.SQLException;

import com.inw.proy.DTO.logged.UserDTO;

public interface UserFinderService {

	UserDTO execute(Integer id) throws NullPointerException, SQLException;

	UserDTO execute(Integer id, String[] fields) throws NullPointerException, SQLException;

}
