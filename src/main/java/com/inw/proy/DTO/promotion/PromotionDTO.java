package com.inw.proy.DTO.promotion;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_promotion")
public class PromotionDTO {

	
	@Expose
	private Integer id;
	@NotNull
	private Integer shopId;
	@Expose
	@SerializedName("menu_id")
	@NotNull
	private Integer menuId;
	@Expose
	@NotNull
	@NotEmpty
	private String name;
	@Expose
	@SerializedName("total_price")
	private Double totalPrice;
	@Expose
	private Integer status;
	
	
	public PromotionDTO() {
		
	}
	
	public PromotionDTO(Integer id, @NotNull Integer shopId, @NotNull Integer menuId, @NotNull @NotEmpty String name,
			@NotNull Double totalPrice, Integer status) {
		this.id = id;
		this.shopId = shopId;
		this.menuId = menuId;
		this.name = name;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getShopId() {
		return shopId;
	}



	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}



	public Integer getMenuId() {
		return menuId;
	}



	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
