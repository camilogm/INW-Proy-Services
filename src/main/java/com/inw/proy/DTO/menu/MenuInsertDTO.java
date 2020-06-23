package com.inw.proy.DTO.menu;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class MenuInsertDTO extends MenuDTO {


	@Valid
	private MenuDetailDTO[] menuDetails;

	public MenuInsertDTO() { 
		
	}

	public MenuInsertDTO(Integer id, Integer shopId, @NotNull @Size(min = 10, max = 30) String name, Integer active,
			Integer periodDate, String date, String code,@Valid MenuDetailDTO[] menuDetails) {
		super(id, shopId, name, active, periodDate, date, code);
		this.menuDetails = menuDetails;
	}
	
	public MenuDetailDTO[] getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(MenuDetailDTO[] menuDetails) {
		this.menuDetails = menuDetails;
	}
	
	public MenuDTO getMenu() { 
		return new MenuDTO(
				getId(), getShopId(), getName(), getActive(), getPeriod(), getDate(), getCode()
				);
	}
	
	

}
	
