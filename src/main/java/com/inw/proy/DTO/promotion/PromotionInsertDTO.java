package com.inw.proy.DTO.promotion;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_promotion")
public class PromotionInsertDTO extends PromotionDTO {

	
	
	@Valid
	@NotNull
	@NotEmpty
	private PromotionDetailDTO[] promotionDetails;

	
	
	public PromotionInsertDTO() {
		super();
	}
	public PromotionInsertDTO(Integer id, @NotNull Integer shopId, @NotNull Integer menuId,
			@NotNull @NotEmpty String name, @NotNull Double totalPrice, 
			Integer status,PromotionDetailDTO[] promotionDetails) {
		super(id, shopId, menuId, name, totalPrice, status);
		this.promotionDetails = promotionDetails;
	}

	public PromotionDetailDTO[] getPromotionDetails() {
		return promotionDetails;
	}



	public void setPromotionDetails(PromotionDetailDTO[] promotionDetails) {
		this.promotionDetails = promotionDetails;
	}


	
	

	



	
}

