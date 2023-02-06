package com.gcu.business;

import java.util.List;
import com.gcu.model.UserModel;


public interface UsersBusinessServiceInterface {
	public List<UserModel> getUsers();
	public int createUser(UserModel userModel);
	public int verifyUsername(UserModel userModel);
	public int verifyEmail(UserModel userModel);

}
