package com.codingdojo.nrampton.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.relationships.models.Person;
import com.codingdojo.nrampton.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository _pr;
	
	public PersonService(PersonRepository personRepository) {
		this._pr = personRepository;
	}
	
	public List<Person> getAllPersons() {
		return (List<Person>) _pr.findAll();
	}
	
	public void createPerson(Person person) {
		_pr.save(person);
	}
	
	public void theNuclearOption() {
		_pr.deleteAll();
	}
}
