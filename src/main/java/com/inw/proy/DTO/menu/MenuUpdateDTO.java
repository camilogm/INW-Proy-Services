package com.inw.proy.DTO.menu;

import javax.validation.Valid;

public class MenuUpdateDTO extends MenuDTO {

	@Valid
	private MenuDetailDTO[] newDetails;
	@Valid
	private MenuDetailDTO[] updateDetails;
	@Valid
	private DeleteMenuDetailDTO[] deletedDetails;
	
	
	public MenuUpdateDTO() {
	}


	public MenuUpdateDTO(@Valid MenuDetailDTO[] newDetails, @Valid MenuDetailDTO[] updateDetails,
			@Valid DeleteMenuDetailDTO[] deletedDetails) {
		this.newDetails = newDetails;
		this.updateDetails = updateDetails;
		this.deletedDetails = deletedDetails;
	}


	public MenuDetailDTO[] getNewDetails() {
		return newDetails;
	}


	public void setNewDetails(MenuDetailDTO[] newDetails) {
		this.newDetails = newDetails;
	}


	public MenuDetailDTO[] getUpdateDetails() {
		return updateDetails;
	}


	public void setUpdateDetails(MenuDetailDTO[] updateDetails) {
		this.updateDetails = updateDetails;
	}


	public DeleteMenuDetailDTO[] getDeletedDetails() {
		return deletedDetails;
	}


	public void setDeletedDetails(DeleteMenuDetailDTO[] deletedDetails) {
		this.deletedDetails = deletedDetails;
	}
	
	public MenuDTO getMenu() { 
		return new MenuDTO(
				getId(), getShopId(), getName(), getActive(), getPeriod(), getDate(), getCode()
				);
	}
	
}
