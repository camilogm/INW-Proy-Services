package com.inw.proy.DTO.menu;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;
import sv.hawklibrary.com.ORM.Annotations.NotDuplicated;
import sv.hawklibrary.com.ORM.Annotations.PrimaryKey;


@DataModelAnnotations(tableName = "J0120_menu")
public class MenuDTO {

	@Expose
	@PrimaryKey
	private Integer id;	
	@Expose
	@NotNull
	@SerializedName("shop_id")
	private Integer shopId;
	@Expose
	@NotNull
	@Size(min = 10,max = 30)
	private String name;
	@Expose
	private Integer active;
	@Expose
	@SerializedName("period")
	private Integer period;
	@Expose
	private String date;
	@Expose
	@NotDuplicated
	private String code;
	
	public MenuDTO() {
		
	}
	
	public MenuDTO(Integer id, Integer shopId, @NotNull @Size(min = 10, max = 30) String name, Integer active,
			Integer period, String date, String code) {
		this.id = id;
		this.shopId = shopId;
		this.name = name;
		this.active = active;
		this.period = period;
		this.date = date;
		this.code = code;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer periodDate) {
		this.period = periodDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
