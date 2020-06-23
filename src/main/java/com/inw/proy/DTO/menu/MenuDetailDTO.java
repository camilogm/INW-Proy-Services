package com.inw.proy.DTO.menu;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_menu_detail")
public class MenuDetailDTO {

	@Expose
	private Integer id;
	@Expose
	@SerializedName("menu_id")
	private Integer menuId;
	@Expose
	@NotNull
	@SerializedName("product_name")
	private String productName;
	@Expose
	@SerializedName("unitary_price")
	@NotNull
	private Double unitaryPrice;
	@Expose
	@SerializedName("product_category")
	private String productCategory;
	
	public MenuDetailDTO() {
		
	}
	
	public MenuDetailDTO(Integer id, Integer menuId, @NotNull String productName, @NotNull Double unitaryPrice,
			String productCategory) {
		this.id = id;
		this.menuId = menuId;
		this.productName = productName;
		this.unitaryPrice = unitaryPrice;
		this.productCategory = productCategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(Double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	
	
	
	
}
