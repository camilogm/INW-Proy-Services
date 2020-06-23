package com.inw.proy.services.errors;

import com.inw.proy.DTO.errors.FieldErrorDTO;

public interface PromotionDetailErrorService {

	FieldErrorDTO getFieldError(int menuDetailId, String field);

	FieldErrorDTO alredyRegistredDetail(int menuDetailId, int promotionId);

	FieldErrorDTO errorDeleting(int menuDetailId);

}
