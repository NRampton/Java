package com.project.bnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.bnb.models.Review;

@Repository 												
public interface ReviewRepository extends CrudRepository<Review,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
