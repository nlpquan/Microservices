package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ListingsAccessInterface;
import com.gcu.model.ListingModel;
import com.gcu.model.UserModel;

@Service
/**
 * This class has Listing Service methods
 * @author ivangudino me
 *
 */
public class ListingService implements ListingServiceInterface{
	
	
    @Autowired
    ListingsAccessInterface<ListingModel> service;
    
    @Autowired
    UserModel userModel;
    
    @Override
    /**
     * Return the list of listings
     */
    public List<ListingModel> getListings(Long user_Id) {
     // return the list of listings
        return service.findByUser_Id(user_Id);    
    }
    
    @Override
    /**
     * Return the list of active listings
     */
    public List<ListingModel> getActiveListings(Long user_Id) {
     // return the list of listings
        return service.findActiveByUser_Id(user_Id);    
    }

    @Override
    /**
     * Create a listing
     */
    public boolean createListing(ListingModel listingModel) {
        // create a listing
    	listingModel.setStatus(0);
        service.create(listingModel);
        return true;
    }

	@Override
	/**
	 * This method edits the listings
	 */
	public int editListing(ListingModel listingModel) {
		//edit listing
		service.update(listingModel);
		return 0;
	}

	@Override
	/**
	 * This method deletes the listing
	 */
	public int deleteListing(ListingModel listingModel) {
		//delete listing
		service.delete(listingModel);
		return 0;
	}

	@Override
	/**
	 * This method buys the listing
	 */
	public int buyListing(ListingModel listingModel) {
		//buy listing
		service.updateStatus(listingModel);
		return 0;
	}
	
    
}
