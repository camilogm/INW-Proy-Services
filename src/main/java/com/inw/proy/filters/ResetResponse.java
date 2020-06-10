package com.inw.proy.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


public class ResetResponse {

	public static HttpServletResponse execute(String jsonResponse, HttpServletResponse response) throws IOException { 
		
		response.reset();
		response.setStatus(400);
		response.setContentType("application/json");
		response.getWriter().write(jsonResponse);
		response.getWriter().flush();
		response.getWriter().close();
		
		return response;
	}
	
}
