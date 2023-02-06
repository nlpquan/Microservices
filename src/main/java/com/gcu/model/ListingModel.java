package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Listing Model class
 * @author ivangudino
 *
 */
public class ListingModel {
	
    private Long id;
    
	@NotNull(message="Name is a required field")
    @Size(min=1, max=25, message="Name has to be in range of 1 to 25 characters")
	private String name;

	@NotNull(message="Description is a required field")
    @Size(min=1, max=100, message="Description has to be in range of 1 to 10 characters")
	private String description;

	/*
	 * Categories
	 * 1. Processor
	 * 2. Motherboard
	 * 3. Graphics Card
	 * 4. RAM
	 * 5. Storage
	 * 6. Power Supply
	 */
	@Min(value=1, message="Category cannot be empty")
	private int category;

	@Min(value=1, message="0 is not a suitable number")
	private float price;
	
	//0 Active
	//1 SOLD
	private int status;
	
	private Long user_id;
	
	
	public ListingModel(Long id, String name, String description, int category, float price, int status, Long user_id)
	{
	    this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.status = status;
		this.user_id = user_id;
	}
	public ListingModel()
	{

	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Get the category
	 * @return category
	 */
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	

}
