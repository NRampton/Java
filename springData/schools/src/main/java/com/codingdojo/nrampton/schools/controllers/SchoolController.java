package com.codingdojo.nrampton.schools.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.schools.models.School;
import com.codingdojo.nrampton.schools.services.SchoolService;

@Controller
@RequestMapping("/schools")
public class SchoolController {
	
	private SchoolService schoolService;
	
	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@RequestMapping("/new")
	public String showSchoolForm(Model model, @ModelAttribute("school") School school) {
		return "schoolForm";
	}
	
	@PostMapping("/new")
	public String createSchool(Model model, @ModelAttribute("school") School school, BindingResult result) {
		schoolService.createSchool(school);
		return "redirect:/";
	}
	
	@RequestMapping("/theNuclearOption")
	public String theNuclearOption() {
		schoolService.theNuclearOption();
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String showSchool(Model model, @PathVariable("id") Long id) {
		School school = schoolService.getSchoolById(id);
		model.addAttribute("school", school);
//		List<Student> students = schoolService.getStudentsBySchool(id);
//		model.addAttribute("students", students);
		return "showSchool";
	}
}
