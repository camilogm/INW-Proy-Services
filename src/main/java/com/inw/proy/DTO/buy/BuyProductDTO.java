package com.inw.proy.DTO.buy;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_product_buy")
public class BuyProductDTO {

	@Expose
	@SerializedName("menu_detail_id")
	@NotNull
	private int menuDetailId;
	@Expose
	@NotNull
	@Min(1)
	@Max(30)
	private int quantity;
	@Expose
	@SerializedName("memento_price")
	private Double mementoPrice;
	@Expose
	@SerializedName("product_name")
	private String productName;
	
	public BuyProductDTO() {
	}
	
	
	public BuyProductDTO( @NotNull int menuDetailId, String productName,	
			@Max(30) @Min(1) @NotNull int quantity,
			Double mementoPrice) {
		
		this.menuDetailId = menuDetailId;
		this.productName = productName;
		this.quantity = quantity;
		this.mementoPrice = mementoPrice;
	}


	public int getMenuDetailId() {
		return menuDetailId;
	}

	public void setMenuDetailId(Integer menuDetailId) {
		this.menuDetailId = menuDetailId;
	}

	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getMementoPrice() {
		return mementoPrice;
	}

	public void setMementoPrice(Double mementoPrice) {
		this.mementoPrice = mementoPrice;
	}
	
	
	
	
	
}
