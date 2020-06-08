package com.inw.proy.serializations;




import com.google.gson.Gson;
import com.inw.proy.DTO.LoggedDTO;


public class GetObjectFromGson implements GetObject {

	@Override
	public Object execute(String json) {
		
		System.out.println(json);
		Gson gson = new Gson();
		return gson.fromJson(json, LoggedDTO.class);
	}

}
