package com.inw.proy.serializations;

public interface GetObject {

	Object execute(String json, Class<? extends Object> className);
}
