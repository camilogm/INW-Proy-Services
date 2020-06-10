package com.inw.proy.serializations;

import com.google.gson.Gson;

public class GetStringfyFromGson implements GetStringfy {

	@Override
	public String execute(Object object, Class<? extends Object> classObject) {
	
		Gson gson = new Gson();
		return gson.toJson(object,classObject);
	}

	
}
