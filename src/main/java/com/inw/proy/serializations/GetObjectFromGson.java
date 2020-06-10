package com.inw.proy.serializations;

import com.google.gson.Gson;

public class GetObjectFromGson implements GetObject {

	@Override
	public Object execute(String json,Class<? extends Object> objectClass) {
		
		System.out.println(json);
		Gson gson = new Gson();
		return gson.fromJson(json, objectClass);
	}

}
