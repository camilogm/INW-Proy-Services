package com.inw.proy.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.inw.proy.DTO.LoggedDTO;
import com.inw.proy.externalapis.GetURL;
import com.inw.proy.serializations.GetObject;
import com.inw.proy.serializations.GetObjectFromGson;

import com.inw.proy.utils.UserDetailsLogged;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	
	@Autowired
	@Qualifier("loginAPI")
	private GetURL loginAPI;
	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@Autowired
	private CheckPublicEndPoints checkPublic;

	private GetObject getObject = new GetObjectFromGson();
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (checkPublic.execute(request.getRequestURI())){ 
			filterChain.doFilter(request, response);
			return;
		}
	
		
		
		HttpClient http = HttpClientBuilder.create().build();
		String jwtToken = request.getHeader("authorization");
		String jsonResponse="";
		
		try {
			
			
			HttpPost postRequest = new HttpPost(loginAPI.read("checkaccess")); 
			postRequest.addHeader("content-type","application/json");
			postRequest.addHeader("Accept", "application/json");
			postRequest.addHeader("Authorization",jwtToken);
			
			HttpResponse apiResponse = http.execute(postRequest);
			jsonResponse = EntityUtils.toString(apiResponse.getEntity());
			
			
			if ( apiResponse.getStatusLine().getStatusCode() == HttpStatus.OK.value()) { 
				
				LoggedDTO logged = (LoggedDTO) this.getObject.execute(jsonResponse, LoggedDTO.class);				
				userDetails.setUser(logged.getUser());	
				filterChain.doFilter(request, response);
				return;
			}
				
		}catch (Exception ex) {
			jsonResponse ="\"{'status':400,'message':'Unauthorized'}\"";
			System.out.println("here");
			System.out.println(ex);
		}
		
		response = ResetResponse.execute(jsonResponse, response);
		return;
			
		
	}

}
