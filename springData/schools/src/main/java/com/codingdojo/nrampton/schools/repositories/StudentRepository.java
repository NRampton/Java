package com.codingdojo.nrampton.schools.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.schools.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
