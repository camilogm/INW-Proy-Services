package com.inw.proy.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.NestedServletException;

import com.inw.proy.serializations.GetStringfy;
import com.inw.proy.serializations.GetStringfyFromGson;
import com.inw.proy.utils.Error;
import com.inw.proy.utils.UserDetailsLogged;

@Component
public class PermissionsFilter extends OncePerRequestFilter {

	
	@Autowired
	private UserDetailsLogged userDetails;
	
	@Autowired
	private Error error;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String jsonResponse = "";
		try {

			System.out.println(request.getRequestURI());
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
					new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
			
		    usernamePasswordAuthenticationToken
	        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		    filterChain.doFilter(request, response);
		    return;
		    
		}
	    catch (NestedServletException ex) {
			error.setError(HttpStatus.UNAUTHORIZED.value(), "Not permissions", null);
			GetStringfy getStringfy = new GetStringfyFromGson();
			jsonResponse = getStringfy.execute(error, Error.class);
			
		}
		
		response = ResetResponse.execute(jsonResponse, response);
		return;
		
	}
	
	

}