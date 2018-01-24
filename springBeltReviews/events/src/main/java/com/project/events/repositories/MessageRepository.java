package com.project.events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.events.models.Message;

@Repository 												
public interface MessageRepository extends CrudRepository<Message,Long>{
	
}
