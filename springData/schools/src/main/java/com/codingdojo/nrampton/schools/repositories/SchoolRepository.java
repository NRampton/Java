package com.codingdojo.nrampton.schools.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.schools.models.School;
import com.codingdojo.nrampton.schools.models.Student;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
	public List<Student> findStudentsById(Long id);
}
