package com.inw.proy.serializations;

import com.google.gson.Gson;

public class GetObjectFromGson implements GetObject {

	@Override
	public Object execute(String json,Class<? extends Object> objectClass) {
		
		Gson gson = new Gson();
		return gson.fromJson(json, objectClass);
	}

}
