package com.project.bnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.bnb.models.Pool;

@Repository 												
public interface PoolRepository extends CrudRepository<Pool,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
