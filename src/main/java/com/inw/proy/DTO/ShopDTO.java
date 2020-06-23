package com.inw.proy.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;
import sv.hawklibrary.com.ORM.Annotations.NotDuplicated;

@DataModelAnnotations(tableName = "J0120_shop")
public class ShopDTO {


	@Expose
	private Integer id;
	@Expose
	@SerializedName("user_id")
	private Integer userId;
	@Expose
	@NotNull(message =" Nombre no puede ser nulo")
	@Size(min=10,max = 50)
	@NotDuplicated
	private String name;
	private String imagePath;
	@SerializedName("global_rate")
	@Expose
	private Integer globalRate;
	
	public ShopDTO() {
		
	}
	
	public ShopDTO(Integer id, Integer userId, String name, String imagePath, Integer globalRate) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.imagePath = imagePath;
		this.globalRate = globalRate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getGlobalRate() {
		return globalRate;
	}

	public void setGlobalRate(Integer globalRate) {
		this.globalRate = globalRate;
	}
	
	
	
	
}
