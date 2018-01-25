package com.project.rings.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Company;

@Repository 												
public interface CompanyRepo extends CrudRepository<Company,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
