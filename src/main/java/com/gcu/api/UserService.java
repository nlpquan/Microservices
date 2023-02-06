package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UsersEntity;


@RestController
@RequestMapping("/api")
/**
 * This class is for API calls
 * @author ivangudino
 *
 */
public class UserService {
	
	@Autowired
	UsersDataService service;
	
	@GetMapping("/users")
	/**
	 * This method gets all the products
	 * @return products in json
	 */
	public ResponseEntity<?> getUsers() {
		List<UsersEntity> users = service.findAll();
		try {
			if(users == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				return new ResponseEntity<>(users, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/user/{username}")
	/**
	 * This method gets products by ID
	 * @param id id
	 * @return product in json
	 */
	public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
		//find product by ID
		UsersEntity user = service.findByUsername(username);
		try {
			if(user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
