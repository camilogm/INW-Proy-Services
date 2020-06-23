package com.inw.proy.responses.updates;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.menu.MenuUpdateDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.deletes.DeleteMenuDetailService;
import com.inw.proy.services.inserts.MenuDetailInsertService;
import com.inw.proy.services.updates.MenuDetailUpdateService;
import com.inw.proy.services.updates.MenuUpdateService;

@RestController
public class MenuUpdateController {

	
	@Autowired
	@Qualifier("menuUpdateHF")
	private MenuUpdateService menuUpdateService;
	
	@Autowired
	@Qualifier("menuDetailInsertHF")
	private MenuDetailInsertService menuDetailInsertService;
	
	@Autowired
	@Qualifier("menuDetailUpdateHF")
	private MenuDetailUpdateService menuDetailUpdateService;

	@Autowired
	@Qualifier("deleteMenuDetailHF")
	private DeleteMenuDetailService menuDetailDeleteService;
	
	
	@PatchMapping(value = "/menu/update", headers = "Accept=application/json")
	public ResponseEntity<?> execute(@Valid @RequestBody MenuUpdateDTO menu) throws SQLException{ 
		
		Object data = menuUpdateService.execute(menu);
		menuDetailInsertService.insertMany(menu.getNewDetails(), menu.getId());
		menuDetailUpdateService.updateMany(menu.getUpdateDetails(),menu.getId());
		menuDetailDeleteService.deleteMany(menu.getDeletedDetails());
		
		return new ResponseEntity<>(ResponseCustom.ok(data),HttpStatus.OK);
	}
	
	
}
