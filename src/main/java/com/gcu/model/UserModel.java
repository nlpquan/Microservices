package com.gcu.model;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
/**
 * User Model class
 * @author ivangudino
 *
 */
public class UserModel {
	
	//Imports
	private ListingModel listing;
	
	@Valid public CredentialModel credentials;

	private ArrayList<ListingModel> allListings = new ArrayList<ListingModel>();
	
	//User Sensitive Information
	@Id
	private Long id;
	
	@NotEmpty(message="This field is required")
	private String firstName;
	
	@NotEmpty(message="This field is required")
	private String lastName;
	
	@NotEmpty(message="This field is required")
	@Email
	private String email;
	
	@NotEmpty(message="This field is required")
	private String address;
	
	@NotEmpty(message="This field is required")
	private String city;
	
	@NotEmpty(message="This field is required")
	private String state;
	
	@Size(max=99999, min=1, message="Enter a valid Zipcode")
	private String zipcode;
	
	@Size(min=1, message="Enter a valid Phone Number")
	private String phoneNumber;
	
	
	private int totalNumListings = 0;
	private int totalNumSales = 0;
	private int totalRevenue = 0;
	/**
	 * default constructor
	 */
	public UserModel() {
		credentials = new CredentialModel();
	}
	/**
	 * Constructor for user model
	 * @param firstName first name
	 * @param lastName last name
	 * @param email email
	 */
	public UserModel(String firstName, String lastName,String email ) {
		credentials = new CredentialModel();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	/**
	 * Constructor for user model (Used in LOGIN CONTROLLER)
	 * @param id id
	 * @param username username
	 * @param password password
	 * @param firstName firstName
	 * @param lastName lastName
	 * @param email email
	 * @param address address
	 * @param city city
	 * @param state state
	 * @param zipcode zipcode
	 * @param phoneNumber phoneNumber
	 * @param totalNumListings totalNumlistings
	 * @param totalNumSales totalNumSales
	 * @param totalRevenue totalRevenue
	 */
	public UserModel(Long id,
			String username,
			String password,
			String firstName, 
			String lastName, 
			String email, 
			String address, 
			String city, 
			String state, 
			String zipcode, 
			String phoneNumber, 
			int totalNumListings,
			int totalNumSales, 
			int totalRevenue) {
		credentials = new CredentialModel();
		this.id = id;
		this.credentials.setUsername(username);
		this.credentials.setPassword(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.totalNumListings = totalNumListings;
		this.totalNumSales = totalNumSales;
		this.totalRevenue = totalRevenue;
	}
	/**
	 * Get all listings
	 * @return listings
	 */
	public ListingModel getListing() {
		//remove this
		allListings.size();
		return listing;
	}
	/**
	 * Setter for listings
	 * @param listing listings
	 */
	public void setListing(ListingModel listing) {
		this.listing = listing;
	}
	/**
	 * getter for id
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Setter for Id
	 * @param id id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Getter for first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Setter for first name
	 * @param firstName first Name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * getter for last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Setter for last name
	 * @param lastName last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Getter for email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter for email
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Setter for address
	 * @param address address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * getter for city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Setter for city
	 * @param city city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * getter for state
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * setter for state
	 * @param state state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * getter for zipcode
	 * @return zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * setter for zipcode
	 * @param zipcode zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * getter for phone number
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * setter for phone number
	 * @param phoneNumber phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * get total number of listing
	 * @return total number of listings
	 */
	public int getTotalNumListings() {
		return totalNumListings;
	}
	/**
	 * setter for total number of listings
	 * @param totalNumListings total number of listings
	 */
	public void setTotalNumListings(int totalNumListings) {
		this.totalNumListings = totalNumListings;
	}
	/**
	 * getter for total number of sales
	 * @return total number of sales
	 */
	public int getTotalNumSales() {
		return totalNumSales;
	}
	/**
	 * setter for total number of sales
	 * @param totalNumSales total number of sales
	 */
	public void setTotalNumSales(int totalNumSales) {
		this.totalNumSales = totalNumSales;
	}
	/**
	 * getter for total revenue
	 * @return total revenue
	 */
	public int getTotalRevenue() {
		return totalRevenue;
	}
	/**
	 * setter for total revenue
	 * @param totalRevenue total revenue
	 */
	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	/**
	 * getter for credentials
	 * @return credentials
	 */
	public CredentialModel getCredentials() {
		return credentials;
	}
	/**
	 * getter for credentials
	 * @param credentials credentials
	 */
	public void setCredentials(CredentialModel credentials) {
		this.credentials = credentials;
	}

	
	
}
