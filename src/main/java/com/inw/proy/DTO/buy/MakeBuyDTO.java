package com.inw.proy.DTO.buy;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_buy")
public class MakeBuyDTO extends BuyDTO {
	
	@NotNull
	private Integer menuId;
	@NotNull
	private Integer methodPay;	
	@NotNull
	@NotEmpty
	@Valid
	private BuyProductDTO[] products;
	@Valid
	private BuyPromotionDTO[] promotions;
	
	public MakeBuyDTO() {
		super();
	}
	
	public MakeBuyDTO(Integer id, Integer buyerId, Double totalPrice, String productsBuy
			, String date, @NotNull String localization,
			@NotNull Integer deliveryService, Integer rate,
			@NotNull Integer menuId,
			@NotNull Integer methodPay,
			@NotNull @NotEmpty @Valid BuyProductDTO[] products, 
			@Valid BuyPromotionDTO[] promotions) {
		super(id, buyerId, totalPrice,productsBuy , date, localization, deliveryService, rate);
		
		this.menuId = menuId;
		this.methodPay = methodPay;
		this.products = products;
		this.promotions = promotions;
	
	}
	
	
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMethodPay() {
		return methodPay;
	}

	public void setMethodPay(Integer methodPay) {
		this.methodPay = methodPay;
	}

	public BuyProductDTO[] getProducts() {
		return products;
	}

	public void setProducts(BuyProductDTO[] products) {
		this.products = products;
	}

	public BuyPromotionDTO[] getPromotions() {
		return promotions;
	}

	public void setPromotions(BuyPromotionDTO[] promotions) {
		this.promotions = promotions;
	}

	
}
