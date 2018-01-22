package com.codingdojo.nrampton.employees.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.employees.models.Employee;
import com.codingdojo.nrampton.employees.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository _er;

	public EmployeeService(EmployeeRepository _er) {
		super();
		this._er = _er;
	}
	
	public List<Employee> getAllEmployees() {
		return (List<Employee>) _er.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return _er.save(employee);
	}
	
	public Employee getEmployeeById(Long id) {
		return _er.findOne(id);
	}
}
