package com.inw.proy.DTO.buy;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_buy")
public class BuyDTO {
	
	@Expose
	private Integer id;
	@Expose
	@SerializedName("buyer_id")
	private Integer buyerId;
	@Expose
	@SerializedName("menu_id")
	@NotNull
	private Integer menuId;
	@Expose
	@SerializedName("total_price")
	private Double totalPrice;
	@Expose
	@SerializedName("products_buy")
	private String productsBuy;
	@Expose
	@SerializedName("promotions_buy")
	private String promotionsBuy;
	@Expose
	private String date;
	@Expose
	@NotNull
	private String localization;
	@Expose
	@SerializedName("delivery_service")
	@NotNull
	private Integer deliveryService;
	@Expose
	private Integer rate;
	
	public BuyDTO() {
	
	}
	
	
	public BuyDTO(Integer id, Integer buyerId,
			@NotNull Integer menuId, 
			Double totalPrice,
			String productsBuy,
			String promotionsBuy, String date, @NotNull String localization,
			@NotNull Integer deliveryService, Integer rate
			) {
		super();
		this.id = id;
		this.buyerId = buyerId;
		this.menuId = menuId;
		this.totalPrice = totalPrice;
		this.productsBuy = productsBuy;
		this.promotionsBuy = promotionsBuy;
		this.date = date;
		this.localization = localization;
		this.deliveryService = deliveryService;
		this.rate = rate;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	
	

	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public String getProductsBuy() {
		return productsBuy;
	}


	public void setProductsBuy(String productsBuy) {
		this.productsBuy = productsBuy;
	}

	

	public String getPromotionsBuy() {
		return promotionsBuy;
	}


	public void setPromotionsBuy(String promotionsBuy) {
		this.promotionsBuy = promotionsBuy;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public Integer getDeliveryService() {
		return deliveryService;
	}

	public void setDeliveryService(Integer deliveryService) {
		this.deliveryService = deliveryService;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	
	
	
	
}
