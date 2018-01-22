package com.codingdojo.nrampton.employees.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.employees.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
