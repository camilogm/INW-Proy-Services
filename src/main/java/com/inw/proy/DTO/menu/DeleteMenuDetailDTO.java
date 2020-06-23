package com.inw.proy.DTO.menu;

import javax.validation.constraints.NotNull;

public class DeleteMenuDetailDTO {

	@NotNull
	private Integer shopId;
	@NotNull
	private Integer menuId;
	@NotNull
	private Integer menuDetailId;
	
	public DeleteMenuDetailDTO(@NotNull Integer shopId, @NotNull Integer menuId, @NotNull Integer menuDetailId) {
		this.shopId = shopId;
		this.menuId = menuId;
		this.menuDetailId = menuDetailId;
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

	public Integer getMenuDetailId() {
		return menuDetailId;
	}

	public void setMenuDetailId(Integer menuDetailId) {
		this.menuDetailId = menuDetailId;
	}
	
	
	
	
	
}
