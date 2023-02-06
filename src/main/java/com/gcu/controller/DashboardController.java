package com.gcu.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ListingServiceInterface;
import com.gcu.business.MainBusinessService;
import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.data.ListingsDataService;
import com.gcu.model.ListingModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	UserModel userModel;
	
	@Autowired
	private UsersBusinessServiceInterface userService;
	
	@Autowired
	private ListingServiceInterface service;
	
	@Autowired
	private ListingsDataService listingsDataService;
	
	@Autowired
	MainBusinessService mainBusinessService;

	@GetMapping("")
	/**
	 * Displays dashboard
	 * @param model model
	 * @return dashboard view
	 */
	public String displayDashboard(Model model) {
		if(userModel.credentials.getUsername() == null) {
			return "redirect:/login";
		}
		mainBusinessService.createUserSession(userModel.credentials.getUsername());
		String welcomeMessage = String.format("Welcome Back %s!", userModel.getFirstName());
		model.addAttribute("username", welcomeMessage);
		model.addAttribute("totalSales", userModel.getTotalNumSales());
		model.addAttribute("totalListings", userModel.getTotalNumListings());
		model.addAttribute("totalRevenue", userModel.getTotalRevenue());
		return "dashboard";
	}
	
	@GetMapping("/myListings")
	/**
	 * Display mylisting view
	 * @param model model
	 * @return mylisting view
	 */
	public String displayMyListings(Model model) {
		model.addAttribute("listings", service.getActiveListings(userModel.getId()));
		return "myListings";
	}
	
	/**
	 * displays the deleteListing view
	 * @param listingModel listingModel 
	 * @param model model
	 * @return delete Listing view
	 */
	@PostMapping("/deleteListing")
	public String deleteMyListing(ListingModel listingModel, Model model) {
		listingModel = listingsDataService.findById(listingModel.getId());
		model.addAttribute("listingModel", listingModel);
		return "deleteListing";
	}
	
	@GetMapping("/listings")
	/**
	 * Display listing
	 * @param model model
	 * @return listing view
	 */
	public String displayListings(Model model) {
		model.addAttribute("listings", listingsDataService.findAll());
		model.addAttribute("user", userModel);
		return "listings";
	}
	
	@GetMapping("/create")
	/**
	 * display create view
	 * @param model model
	 * @return create view
	 */
	public String create(Model model)
	{
		model.addAttribute("listingModel", new ListingModel());
		return "create";
	}
	
	@GetMapping("/userList")
	public String displayUserList(Model model)
	{
		model.addAttribute("users", userService.getUsers());
		return "userList";
	}
	
	@PostMapping("deleteSuccess")
	/**
	 * Delete Listing from database
	 * @param id listing Id
	 * @param listingModel listing model
	 * @param model model
	 * @return myListing view
	 */
    public String deleteSuccess(@Valid ListingModel listingModel,BindingResult bindingResult, Model model)
    {
        service.deleteListing(listingModel);
        return "redirect:/dashboard/myListings";
    }
	
	@PostMapping("/editListing")
	/**
	 * display edit listing view
	 * @param model model
	 * @return editListing view
	 */
	public String editListing(ListingModel listingModel, Model model) {
		listingModel = listingsDataService.findById(listingModel.getId());
		model.addAttribute("listingModel", listingModel);
		return "editListing";
	}
	
	@PostMapping("/editSuccess")
	/**
	 * This method is ran when edit is successful
	 * @param listingModel listingModel
	 * @param bindingResult bindingResult
	 * @param model model
	 * @return editListing view if errors or myListings if no errors
	 */
	public String editSuccess(@Valid ListingModel listingModel, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
            return "editListing";
        }
		service.editListing(listingModel);
		return "redirect:/dashboard/myListings";
	}

	@PostMapping("/createSuccess")
	/**
	 * post method for create form 
	 * @param listingModel listingModel
	 * @param bindingResult bindingResult
	 * @param model model
	 * @return createSuccess view
	 */
	public String createSuccess(@Valid ListingModel listingModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
            return "create";
        }
		model.addAttribute("listings", service.createListing(listingModel));

		return "createSuccess";
	}
	
	@PostMapping("/listings")
	/**
	 * Buy a listing
	 * @param listingModel listingModel
	 * @return listings view
	 */
	public String buy(ListingModel listingModel) {
		listingModel = listingsDataService.findById(listingModel.getId());
		service.buyListing(listingModel);
		return "redirect:/dashboard/listings";
		
	}
}