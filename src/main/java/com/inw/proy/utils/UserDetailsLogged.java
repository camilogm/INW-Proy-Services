package com.inw.proy.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.inw.proy.DTO.UserDTO;


@Repository
public class UserDetailsLogged implements UserDetails, CredentialsContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private UserDTO user;

	public UserDetailsLogged() {
		
	}	
	
	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		ArrayList<SimpleGrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setUserName(String userName) { 
		this.userName = userName;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		
		this.user = user;
		this.userName = user.getName();
	}

	
	
	
	
}
