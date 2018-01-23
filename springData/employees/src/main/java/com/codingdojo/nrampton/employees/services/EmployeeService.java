package com.codingdojo.nrampton.employees.services;

import java.util.ArrayList;
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
	
	public List<Employee> getProspectiveUnderlings(Employee employee) {
		List<Employee> prospectiveUnderlings = (List<Employee>) _er.findAll();
		List<Employee> employeeUnderlings = employee.getEmployees();
		for ( Employee underling : employeeUnderlings) {
			prospectiveUnderlings.remove(underling);
			prospectiveUnderlings.remove(employee);
		}
		return prospectiveUnderlings;
	}
	
	public List<Employee> getProspectiveOverlords() {
		List<Employee> prospectiveOverlords = new ArrayList<Employee>();
		List<Employee> allEmployees = (List<Employee>) _er.findAll();
		for (Employee employee : allEmployees) {
			if (employee.getEmployees().size() > 0) {
				prospectiveOverlords.add(employee);
			}
		}
		return prospectiveOverlords;
	}
	
	public void addUnderlingToOverlord(Long overlordId, Long underlingId) {
		Employee overlord = _er.findOne(overlordId);
		Employee underling = _er.findOne(underlingId);
		overlord.getEmployees().add(underling);
		underling.setManager(overlord);
		_er.save(overlord);
		_er.save(underling);
	}
}
