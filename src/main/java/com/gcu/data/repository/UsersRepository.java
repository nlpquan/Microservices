package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UsersEntity;

public interface UsersRepository extends CrudRepository<UsersEntity, Long>{
	
	UsersEntity findByEmail(String email);
	UsersEntity findByUsername(String username);

}
