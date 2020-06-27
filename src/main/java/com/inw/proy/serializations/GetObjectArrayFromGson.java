package com.inw.proy.serializations;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class GetObjectArrayFromGson<T> {


	public ArrayList<T> execute(String jsonArray) {
		
		if (jsonArray != null) { 
			
			System.out.println("probando sonido");
			
			ArrayList<T> array;    
			Type listType = new TypeToken<ArrayList<T>>() {
			                    }.getType();
			                    
	         Gson gson = new GsonBuilder()
			           		.setLongSerializationPolicy(LongSerializationPolicy.STRING)
			           		.excludeFieldsWithoutExposeAnnotation().create();
			           	    
			 array =  gson.fromJson(jsonArray, listType);
			
			 
			 
			 return array;
		}	
		return null;
	}

}
