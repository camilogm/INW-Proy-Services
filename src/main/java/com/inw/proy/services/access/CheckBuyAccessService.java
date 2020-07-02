package com.inw.proy.services.access;

import java.sql.SQLException;

import com.inw.proy.DTO.TwoObjectsDTO;

public interface CheckBuyAccessService {

	TwoObjectsDTO execute(Integer buyId) throws NullPointerException, SQLException;

	Boolean executeBoolean(Integer buyId) throws NullPointerException, SQLException;
	
	Boolean executeBooleanDelete(Integer buyerId);

}
