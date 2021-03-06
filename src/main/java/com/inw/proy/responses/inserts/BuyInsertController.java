package com.inw.proy.responses.inserts;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inw.proy.DTO.TwoObjectsDTO;
import com.inw.proy.DTO.buy.BuyDTO;
import com.inw.proy.DTO.buy.BuyProductDTO;
import com.inw.proy.DTO.buy.BuyPromotionDTO;
import com.inw.proy.DTO.buy.MakeBuyDTO;
import com.inw.proy.DTO.responses.ResponseCustom;
import com.inw.proy.services.inserts.BuyInsertService;
import com.inw.proy.services.inserts.BuyProductInsertService;
import com.inw.proy.services.inserts.BuyPromotionInsertService;
import com.inw.proy.services.updates.FinishBuyService;

@RestController
public class BuyInsertController {

	@Autowired
	@Qualifier("buyInsertHF")
	private BuyInsertService buyInsertService;
	
	@Autowired
	@Qualifier("buyProductInsertHF")
	private BuyProductInsertService buyProductInsertService;
	
	
	@Autowired
	@Qualifier("buyPromotionInsertHF")
	private BuyPromotionInsertService buyPromotionInsertService;
	
	@Autowired
	@Qualifier("finishBuyHF")
	private FinishBuyService finishBuyService;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/buy/make",headers = "Accept=application/json")
	private ResponseEntity<?> execute(@Valid @RequestBody MakeBuyDTO buy) throws SQLException{
		
		BuyDTO data = buyInsertService.execute(buy);
		TwoObjectsDTO productDetails = buyProductInsertService
									.insertMany(buy.getProducts(), buy.getMenuId());
	
		TwoObjectsDTO promotionDetails = buyPromotionInsertService
											.insertMany(buy.getPromotions(), buy.getMenuId());
								
		MakeBuyDTO dataFinal = (MakeBuyDTO) finishBuyService.execute
						(data.getId(),
						(ArrayList<BuyProductDTO>) productDetails.getObjectOne(), 
						(ArrayList<BuyPromotionDTO>) promotionDetails.getObjectOne());
		
		
		if (productDetails.getObjectTwo()!=null)
			return new ResponseEntity<>(
					ResponseCustom.partial_content(dataFinal, productDetails.getObjectTwo()),
					HttpStatus.PARTIAL_CONTENT
					);
		
		
		return new ResponseEntity<>(
				ResponseCustom.ok(dataFinal),HttpStatus.OK
				);
	}
}
