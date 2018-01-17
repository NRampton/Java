package com.codingdojo.nrampton.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

}
