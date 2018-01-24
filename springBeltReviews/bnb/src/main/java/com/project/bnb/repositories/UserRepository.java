package com.project.bnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.bnb.models.User;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
