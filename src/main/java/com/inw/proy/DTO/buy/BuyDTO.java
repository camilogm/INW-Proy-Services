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
	@SerializedName("total_price")
	private Double totalPrice;
	@Expose
	@SerializedName("products_buy")
	private String productsBuy;
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
	
	
	public BuyDTO(Integer id, Integer buyerId, Double totalPrice,String productsBuy, String date, @NotNull String localization,
			@NotNull Integer deliveryService, Integer rate
			) {
		super();
		this.id = id;
		this.buyerId = buyerId;
		this.totalPrice = totalPrice;
		this.productsBuy = productsBuy;
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
