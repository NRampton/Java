package com.codingdojo.nrampton.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.relationships.models.Person;
import com.codingdojo.nrampton.relationships.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	
	private PersonService _ps;
	
	public PersonController(PersonService personService) {
		this._ps = personService;
	}
	
	@RequestMapping("/new")
	public String addPerson(Model model, @ModelAttribute("person") Person person) {
		return "addPerson";
	}
	
	@PostMapping("/new")
	public String createPerson(Model model, @ModelAttribute("person") Person person, BindingResult result) {
		_ps.createPerson(person);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteAll/noSeriously")
	public String theNuclearOption() {
		_ps.theNuclearOption();
		return "redirect:/";
	}
}
