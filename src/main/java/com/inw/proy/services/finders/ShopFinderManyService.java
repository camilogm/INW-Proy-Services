package com.inw.proy.services.finders;

import java.util.ArrayList;

import com.inw.proy.DTO.ShopDTO;

import sv.hawklibrary.com.ORM.ConditionsStructure;

public interface ShopFinderManyService {

	ArrayList<ShopDTO> execute(ConditionsStructure conditions);

}
