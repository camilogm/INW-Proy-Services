package com.inw.proy.services.finders;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.logged.UserDTO;

import sv.hawklibrary.com.ORM.ORMApplicationTables;

@Service
@Qualifier("userFinderHF")
public class UserFinderHF implements UserFinderService {

	private ORMApplicationTables<UserDTO> userORM;
	
	public UserFinderHF() {
		this.userORM = new ORMApplicationTables<>(UserDTO.class);
	}
	
	@Override
	public UserDTO execute(Integer id ) throws NullPointerException, SQLException {
		
		return userORM.find(id);
	}
	
	@Override
	public UserDTO execute(Integer id , String[] fields) throws NullPointerException, SQLException {
		return userORM.find(id,fields);
			
	}
	
}
