package com.inw.proy.DTO.menu;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_promotion_details")
public class PromotionDetailDTO {

	@Expose
	private Integer id;
	@Expose
	@SerializedName("promotion_id")
	private Integer promotionId;
	@Expose
	@NotNull
	@SerializedName("menu_detail_id")
	private Integer menuDetailId;
	@Expose
	@NotNull
	private Integer quantity;
	
	public PromotionDetailDTO() { 
		
	}
	
	public PromotionDetailDTO(Integer id, Integer promotionId, @NotNull Integer menuDetailId,
			@NotNull Integer quantity) {
		this.id = id;
		this.promotionId = promotionId;
		this.menuDetailId = menuDetailId;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public Integer getMenuDetailId() {
		return menuDetailId;
	}

	public void setMenuDetailId(Integer menuDetailId) {
		this.menuDetailId = menuDetailId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

	
}
