package com.codingdojo.nrampton.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
