package com.inw.proy.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.NestedServletException;

import com.inw.proy.serializations.GetStringfy;
import com.inw.proy.serializations.GetStringfyFromGson;
import com.inw.proy.utils.CheckPublicEndPoints;
import com.inw.proy.utils.Error;
import com.inw.proy.utils.ResetResponse;
import com.inw.proy.utils.UserDetailsLogged;

@Component
@Order(3)
public class PermissionsFilter extends OncePerRequestFilter {

	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@Autowired
	private Error error;
	
	@Autowired
	private CheckPublicEndPoints checkPublic;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		
		System.out.println("permisifilter");
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
        
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
		
		if (checkPublic.execute(request.getRequestURI())){ 
			filterChain.doFilter(request, response);
			return;
		}
	
		
		
		String jsonResponse = "";
		try {

			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
					new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
			
		    usernamePasswordAuthenticationToken
	        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		    filterChain.doFilter(request, response);
		    return;
		    
		}
	    catch (NestedServletException ex) {
			error.setError( "Not permissions", null);
			GetStringfy getStringfy = new GetStringfyFromGson();
			jsonResponse = getStringfy.execute(error, Error.class);
			
		}
		
		response = ResetResponse.execute(jsonResponse, response);
		return;
		
	}
	
	

}
