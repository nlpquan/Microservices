package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ListingsDataService;
import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UsersEntity;
import com.gcu.model.ListingModel;
import com.gcu.model.UserModel;

@Service
public class MainBusinessService implements MainBusinessServiceInterface {
	
	@Autowired
	UsersDataService usersDataService;
	
	@Autowired
	ListingsDataService listingsDataService;
	
	@Autowired
	UserModel userModel;

	@Override
	/**
	 * This method updates user data that comes from the database and updates the instance of a usermodel with the current user
	 */
	public UserModel createUserSession(String username) {
		UsersEntity usersEntity = usersDataService.findByUsername(username);
		// update the usermodel from database data
			userModel.setId(usersEntity.getId());
			userModel.credentials.setUsername(usersEntity.getUsername());
			userModel.credentials.setPassword(usersEntity.getPassword());
			userModel.setFirstName(usersEntity.getFirstName());
			userModel.setLastName(usersEntity.getLastName());
			userModel.setEmail(usersEntity.getEmail());
			userModel.setAddress(usersEntity.getAddress());
			userModel.setCity(usersEntity.getCity());
			userModel.setState(usersEntity.getState());
			userModel.setZipcode(usersEntity.getZipcode());
			userModel.setPhoneNumber(usersEntity.getPhoneNumber());

			updateListings();
			
			return userModel;
	}
	/**
	 * This method find all listings created by the user and updated the listing count.
	 */
	public int updateListings() {
		//populate the listing with database data
		int soldListings = 0;
		int soldRevenue = 0;
		
		List<ListingModel> listings = listingsDataService.findByUser_Id(userModel.getId());
		userModel.setTotalNumListings(listings.size());
		
		for (ListingModel listing : listings) {
			if(listing.getStatus() == 1) {
				soldListings++;
				soldRevenue = (int) (soldRevenue + listing.getPrice());
			}
		}
		userModel.setTotalNumSales(soldListings);
		userModel.setTotalRevenue(soldRevenue);
		
		return 0;
	}

}
