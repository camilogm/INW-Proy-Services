package com.inw.proy.services.errors;

import com.inw.proy.DTO.errors.FieldErrorDTO;

public interface ProductBuyCheckService {

	FieldErrorDTO execute(Integer menuDetailId, Integer buyId);

}
