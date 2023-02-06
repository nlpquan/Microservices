package com.gcu.model;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
/**
 * Credential Model class
 * @author ivangudino
 * Credentials
 */
public class CredentialModel {
	
	//username and password
	
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String username;
	
	@Size(min=6, max=32, message="Password must be between 6-32 characters")
	private String password;
	/**
	 * default constructor
	 */
	public CredentialModel() {
		username = null;
		password = null;
	}
	/**
	 * getter for username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * setter for username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter for password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
