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
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.inw.proy.DTO.LoggedDTO;
import com.inw.proy.DTO.ResponseDTO;
import com.inw.proy.externalapis.GetURL;
import com.inw.proy.serializations.GetObject;
import com.inw.proy.serializations.GetObjectFromGson;
import com.inw.proy.serializations.GetStringfy;
import com.inw.proy.serializations.GetStringfyFromGson;
import com.inw.proy.utils.CheckPublicEndPoints;
import com.inw.proy.utils.Error;
import com.inw.proy.utils.ResetResponse;
import com.inw.proy.utils.UserDetailsLogged;


@Component
@Order(2)
public class JwtRequestFilter extends OncePerRequestFilter {

	
	@Autowired
	@Qualifier("loginAPI")
	private GetURL loginAPI;
	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@Autowired
	private CheckPublicEndPoints checkPublic;

	@Autowired
	private Error error;
	
	private GetObject getObject = new GetObjectFromGson();
	private GetStringfy getStringfy = new GetStringfyFromGson();
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String jwtToken = request.getHeader("authorization");
		
		if (checkPublic.execute(request.getRequestURI()
				) && jwtToken==null){ 
			filterChain.doFilter(request, response);
			return;
		}
	
		
		HttpClient http = HttpClientBuilder.create().build();		
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
			}else { 
				error.setError((Error) this.getObject.execute(jsonResponse, Error.class)); 
			}
				
		}catch (Exception ex) {
			error.setError( "Not permissions", null);
		}
	
		ResponseDTO resp = new ResponseDTO(HttpStatus.UNAUTHORIZED.value(), "", null, error);	
		response = ResetResponse.execute(getStringfy.execute(resp, ResponseDTO.class), response,HttpStatus.UNAUTHORIZED.value());
		return;
			
		
	}

}
