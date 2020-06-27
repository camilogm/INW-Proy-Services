package com.inw.proy.services.access;

import com.inw.proy.DTO.logged.UserDTO;

public interface CheckBuyAccessService {

	UserDTO execute(Integer buyerId);

	Boolean executeBoolean(Integer buyerId);

}
