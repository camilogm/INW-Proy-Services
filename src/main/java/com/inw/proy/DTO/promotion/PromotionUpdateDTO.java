package com.inw.proy.DTO.promotion;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_promotion")
public class PromotionUpdateDTO extends PromotionDTO {

	@Valid
	private PromotionDetailDTO[] newDetails;
	@Valid
	private PromotionDetailDTO[] updateDetails;
	private Integer[] deleteDetails;
	
	public PromotionUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PromotionUpdateDTO(Integer id, @NotNull Integer shopId, @NotNull Integer menuId,
			@NotNull @NotEmpty String name, @NotNull Double totalPrice, Integer status,
			PromotionDetailDTO[] newDetails, PromotionDetailDTO[] updateDetails, Integer[] deleteDetails ) {
		super(id, shopId, menuId, name, totalPrice, status);
		this.newDetails = newDetails;
		this.updateDetails = updateDetails;
		this.deleteDetails = deleteDetails;
	}
	public PromotionDetailDTO[] getNewDetails() {
		return newDetails;
	}
	public void setNewDetails(PromotionDetailDTO[] newDetails) {
		this.newDetails = newDetails;
	}
	public PromotionDetailDTO[] getUpdateDetails() {
		return updateDetails;
	}
	public void setUpdateDetails(PromotionDetailDTO[] updateDetails) {
		this.updateDetails = updateDetails;
	}
	public Integer[] getDeleteDetails() {
		return deleteDetails;
	}
	public void setDeleteDetails(Integer[] deleteDetails) {
		this.deleteDetails = deleteDetails;
	}
	
	
	
	
}
