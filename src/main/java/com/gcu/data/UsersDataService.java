package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UsersEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements DataAccessInterface<UsersEntity> {
	
	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * Constructor for DataService
	 * @param usersRepository user Repository 
	 */
	public UsersDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	//unimplemented method
	/**
	 * Find every user
	 */
	public List<UsersEntity> findAll() {
		List<UsersEntity> users = new ArrayList<UsersEntity>();
		
		try
		{
			// Get all the entity orders
			Iterable<UsersEntity> usersIterable = usersRepository.findAll();
			
			// COnvert to a List and return the List
			users = new ArrayList<UsersEntity>();
			usersIterable.forEach(users::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	/**
	 * This method creates a user to the database
	 */
	public boolean create(UsersEntity user) {
		try {
			this.usersRepository.save(user);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	/**
	 * This method updates user to database
	 */
	public boolean update(UsersEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * this method deletes from database
	 */
	public boolean delete(UsersEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * This method finds a username in the database
	 */
	public UsersEntity findByUsername(String username) {
		UsersEntity usersEntity = usersRepository.findByUsername(username);
		return usersEntity;
	}

	@Override
	/**
	 * This method find a email in the database
	 */
	public UsersEntity findByEmail(String email) {
		UsersEntity usersEntity = usersRepository.findByEmail(email);
		return usersEntity;
	}

}
