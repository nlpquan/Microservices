package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public class UsersEntity {
	
	@Id
	Long id;
	
	@Column("USERNAME")
	String username;
	
	@Column("PASSWORD")
	String password;
	
	@Column("FIRST_NAME")
	String firstName;
	
	@Column("LAST_NAME")
	String lastName;
	
	@Column("EMAIL")
	String email;
	
	@Column("ADDRESS")
	String address;
	
	@Column("CITY")
	String city;
	
	@Column("STATE")
	String state;
	
	@Column("ZIPCODE")
	String zipCode;
	
	@Column("PHONE_NUMBER")
	String phoneNumber;
	
	@Column("TOTAL_NUM_LISTINGS")
	int totalNumListings;
	
	@Column("TOTAL_NUM_SALES")
	int totalNumSales;
	
	@Column("TOTAL_REVENUE")
	int totalRevenue;
	
	
	public UsersEntity(Long id, String username, String password, String firstName, String lastName, String email, String address, String city,
			String state, String zipCode, String phoneNumber, int totalNumListings, int totalNumSales,
			int totalRevenue) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.totalNumListings = totalNumListings;
		this.totalNumSales = totalNumSales;
		this.totalRevenue = totalRevenue;
	}
	
	/**
	 * getter for username
	 * @return username
	 */
	public String getUsername() {
		return username;
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
	/**
	 * setter for username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
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
		return zipCode;
	}
	/**
	 * setter for zipcode
	 * @param zipcode zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipCode = zipcode;
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
	

}
