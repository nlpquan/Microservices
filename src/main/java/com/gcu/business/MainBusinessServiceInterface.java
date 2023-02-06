package com.gcu.business;

import com.gcu.model.UserModel;

public interface MainBusinessServiceInterface {
	
	public UserModel createUserSession(String username);
	public int updateListings();

}
