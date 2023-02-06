package com.gcu.business;

import java.util.List;

import com.gcu.model.ListingModel;
/**
 * Listing Service Interface
 * @author ivangudino
 *
 */
public interface ListingServiceInterface {
	/**
	 * Get listings from database
	 * @param user_Id user id
	 * @return List of ListingModel
	 */
    public List<ListingModel> getListings(Long user_Id);
    public List<ListingModel> getActiveListings(Long user_Id);
    public boolean createListing(ListingModel listingModel);
    
    public int editListing(ListingModel listingModel);
    public int deleteListing(ListingModel listingModel);
    
    public int buyListing(ListingModel listingModel);
}
