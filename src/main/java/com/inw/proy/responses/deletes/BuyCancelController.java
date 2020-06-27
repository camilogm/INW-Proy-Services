package com.inw.proy.responses.deletes;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.deletes.BuyCancelService;

@RestController
public class BuyCancelController {

	@Autowired
	@Qualifier("buyCancelHF")
	private BuyCancelService buyCancelService;
	
	@DeleteMapping(value = "/buy/delete/{id}",headers = "Accept=application/json")
	public ResponseEntity<?> execute(@PathVariable("id") Integer buyId) throws NullPointerException, SQLException{
		
		Object data = buyCancelService
						.execute(buyId);
		
		return new ResponseEntity<>(ResponseCustom.ok(data),HttpStatus.OK);
	}
	
}
