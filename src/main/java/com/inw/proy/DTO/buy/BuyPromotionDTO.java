package com.inw.proy.DTO.buy;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.inw.proy.DTO.promotion.PromotionDetailDTO;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_promotion_details")
public class BuyPromotionDTO {

	@Expose
	@SerializedName("promotion_id")
	@NotNull
	private Integer promotionId;
	@Expose
	@SerializedName("promotion_name")
	private String promotionName;
	@Expose
	private Integer quantity;
	@Expose
	@SerializedName("memento_price")
	private Integer mementoPrice;
	@Expose
	@SerializedName("details")
	private ArrayList<PromotionDetailDTO> details;
	
	
	public BuyPromotionDTO() {
	}


	public BuyPromotionDTO(@NotNull Integer promotionId, String promotionName, Integer quantity, Integer mementoPrice,
			ArrayList<PromotionDetailDTO> details) {
		this.promotionId = promotionId;
		this.promotionName = promotionName;
		this.quantity = quantity;
		this.mementoPrice = mementoPrice;
		this.details = details;
	}


	public Integer getPromotionId() {
		return promotionId;
	}


	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}


	public String getPromotionName() {
		return promotionName;
	}


	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getMementoPrice() {
		return mementoPrice;
	}


	public void setMementoPrice(Integer mementoPrice) {
		this.mementoPrice = mementoPrice;
	}


	public ArrayList<PromotionDetailDTO> getDetails() {
		return details;
	}


	public void setDetails(ArrayList<PromotionDetailDTO> details) {
		this.details = details;
	}

	

}
