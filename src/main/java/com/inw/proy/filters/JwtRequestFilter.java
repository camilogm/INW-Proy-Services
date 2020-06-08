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
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.inw.proy.DTO.LoggedDTO;
import com.inw.proy.DTO.User;
import com.inw.proy.externalapis.GetURL;
import com.inw.proy.serializations.GetObject;
import com.inw.proy.serializations.GetObjectFromGson;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	
	@Autowired
	@Qualifier("loginAPI")
	private GetURL loginAPI;

	private GetObject getObject = new GetObjectFromGson();
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

	
		int d=(int) (Math.random()+1);
		
		
		HttpClient http = HttpClientBuilder.create().build();
		String jwtToken = request.getHeader("authorization");
		
		if (jwtToken!=null && jwtToken.startsWith("Bearer ")) {
		
			try {
				
				
				HttpPost postRequest = new HttpPost(loginAPI.read("checkaccess")); 
				postRequest.addHeader("content-type","application/json");
				postRequest.addHeader("Accept", "application/json");
				postRequest.addHeader("Authorization",jwtToken);
				
				HttpResponse apiResponse = http.execute(postRequest);
				String jsonResponse = EntityUtils.toString(apiResponse.getEntity());
				
				if (getObject != null ) { 
					LoggedDTO log = (LoggedDTO) getObject.execute(jsonResponse);
					System.out.println(log.getAuthenticated());
					System.out.println(log.getUser().getName());
				}else {
					System.out.println("es nulo");
				}
				
			}catch (Exception ex) {
				System.out.println("here");
				System.out.println(ex);
			}
			
		}
		
		if (d%2==0) {
			filterChain.doFilter(request, response);	
		}else {
			
			response.reset();
			response.setStatus(400);
			response.getWriter().println(new User("rea","rewa","rewa","eraw"));
			response.getWriter().flush();
			return;
			
		}
		
		

	}

}
