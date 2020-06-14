package com.inw.proy.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.NestedServletException;

import com.inw.proy.DTO.ResponseDTO;
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
	
	private GetStringfy getStringfy = new GetStringfyFromGson();
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (checkPublic.execute(request.getRequestURI())){ 
			filterChain.doFilter(request, response);
			return;
		}
	
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
		}
		
		ResponseDTO resp = new ResponseDTO(HttpStatus.UNAUTHORIZED.value(), "", null, error);
		response = ResetResponse.execute(getStringfy.execute(resp, ResponseDTO.class), response,HttpStatus.UNAUTHORIZED.value());
		
		return;
		
	}
	
	

}
