package com.inw.proy.DTO.logged;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

import sv.hawklibrary.com.ORM.Annotations.DataModelAnnotations;

@DataModelAnnotations(tableName = "J0120_user")
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Expose
	private Integer id;
	@Expose
	private String email;
	private String password;
	@Expose
	private String name;
	@Expose
	private String lastName;
	private String rol;
	@Expose
	private String phone;
	
	public UserDTO() {
		
	}
	
	public UserDTO( Integer id,String email, String password, String name, String lastName, String rol,
			String phone) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.rol = rol;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	

}
