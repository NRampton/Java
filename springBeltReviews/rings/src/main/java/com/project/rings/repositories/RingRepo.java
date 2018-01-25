package com.project.rings.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Ring;

@Repository 												
public interface RingRepo extends CrudRepository<Ring,Long>{
	
	@Query(value="SELECT r FROM Ring r JOIN r.smith s WHERE s.level > 0")
	List<Ring> findAvailableRings();
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
