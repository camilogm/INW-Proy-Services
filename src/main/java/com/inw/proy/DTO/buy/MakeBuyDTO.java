package com.inw.proy.DTO.buy;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_buy")
public class MakeBuyDTO extends BuyDTO {
	
	
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
	
	public MakeBuyDTO(Integer id, Integer buyerId, Double totalPrice, 
			String productsBuy,
			String promotionsBuy,
			String date, @NotNull String localization,
			@NotNull Integer deliveryService, Integer rate,
			@NotNull Integer menuId,
			@NotNull Integer methodPay,
			@NotNull @NotEmpty @Valid BuyProductDTO[] products, 
			@Valid BuyPromotionDTO[] promotions) {
		super(id, buyerId,menuId, totalPrice,productsBuy
				,promotionsBuy, date, localization, deliveryService, rate);
		
		this.methodPay = methodPay;
		this.products = products;
		this.promotions = promotions;
	
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
