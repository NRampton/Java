package com.project.events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.events.models.Event;

@Repository 												
public interface EventRepository extends CrudRepository<Event,Long>{
	
}
