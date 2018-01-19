package com.codingdojo.nrampton.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.dojooverflow.models.JointQT;

@Repository
public interface JointQTRepository extends CrudRepository<JointQT, Long> {

}
