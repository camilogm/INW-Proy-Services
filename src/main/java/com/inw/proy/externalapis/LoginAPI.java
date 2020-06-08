package com.inw.proy.externalapis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("loginAPI")
public class LoginAPI implements GetURL {

	@Override
	public String read() {

		return "https://inw-login.herokuapp.com/";
	}

	@Override
	public String read(String aditional) {
		// TODO Auto-generated method stub
		return "https://inw-login.herokuapp.com/"+aditional;
	}
	
	

}
