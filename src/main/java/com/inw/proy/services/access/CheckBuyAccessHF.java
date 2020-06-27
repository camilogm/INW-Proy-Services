package com.inw.proy.services.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inw.proy.DTO.logged.UserDTO;
import com.inw.proy.utils.UserDetailsLogged;

@Service
@Qualifier("checkBuyAccessHF")
public class CheckBuyAccessHF implements CheckBuyAccessService {

	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@Override
	public UserDTO execute(Integer buyerId) { 
		
		if (userDetails.getUser().getId() == buyerId) { 
			return userDetails.getUser();
		}
		return null;
	}
	
	@Override
	public Boolean executeBoolean(Integer buyerId) { 
		
		if (userDetails.getUser().getId() == buyerId) { 
			return true;
		}
		return false;
	}
}
