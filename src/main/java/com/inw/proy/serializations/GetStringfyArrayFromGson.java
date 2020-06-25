package com.inw.proy.serializations;

import com.google.gson.Gson;

public class GetStringfyArrayFromGson implements GetStringfy {

	@Override
	public String execute(Object object, Class<? extends Object> classObject) {
	
		return object!=null ? new  Gson().toJsonTree(object)
				.getAsJsonArray()
				.toString() : "";
	}

	
}
