package com.inw.proy.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inw.proy.configurations.PathEnviroment;

@Component
public class CheckPublicEndPoints {

	@Autowired
	private PathEnviroment env;
	
	
	public Boolean execute(String path) {	
		return  Boolean.parseBoolean(env.getProperty(path));
	}
	
}
