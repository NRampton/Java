package com.codingdojo.nrampton.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
