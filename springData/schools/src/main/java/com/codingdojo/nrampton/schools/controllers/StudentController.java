package com.codingdojo.nrampton.schools.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.schools.models.Student;
import com.codingdojo.nrampton.schools.services.SchoolService;
import com.codingdojo.nrampton.schools.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

		private StudentService studentService;
		private SchoolService schoolService;
		
		public StudentController(StudentService studentService, SchoolService schoolService) {
			this.studentService = studentService;
			this.schoolService = schoolService;
		}
		
		@RequestMapping("/new")
		public String showStudentForm(Model model, @ModelAttribute("student") Student student) {
			System.out.println(schoolService.getAllSchools().toString());
			model.addAttribute("schools", schoolService.getAllSchools());
			return "studentForm";
		}
		
		@PostMapping("/new")
		public String createStudent(Model model, @ModelAttribute("student") Student student, BindingResult result) {
			studentService.createStudent(student);
			return "redirect:/";
		}
		
		@RequestMapping("/theNuclearOption")
		public String theNuclearOption() {
			studentService.deleteAll();
			return "redirect:/";
		}
}
