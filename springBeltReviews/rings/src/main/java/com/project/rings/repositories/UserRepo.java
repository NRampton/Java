package com.project.rings.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.User;

@Repository 												
public interface UserRepo extends CrudRepository<User,Long>{
	
	User findByEmail(String email);
	User findByUsername(String username);
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
