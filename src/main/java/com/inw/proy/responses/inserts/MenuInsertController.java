package com.inw.proy.responses.inserts;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.menu.MenuDTO;
import com.inw.proy.DTO.menu.MenuInsertDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.inserts.MenuDetailInsertService;
import com.inw.proy.services.inserts.MenuInsertService;

@RestController
public class MenuInsertController {
	
	
	@Autowired
	@Qualifier("menuInsertHF")
	private MenuInsertService menuInsert;
	
	@Autowired
	@Qualifier("menuDetailInsertHF")
	private MenuDetailInsertService menuDetailsService;
	
	
	@PostMapping(value = "/menu/create",headers = "Accept=application/json")
	public ResponseEntity<?> execute(@Valid @RequestBody MenuInsertDTO menu) throws SQLException{
		
		MenuDTO menuResponse = (MenuDTO) menuInsert.execute(menu);		
		menuDetailsService.insertMany(menu.getMenuDetails(), menuResponse.getId());
		
		
		return ResponseEntity.ok(ResponseCustom.ok(menuResponse));
	}

}
