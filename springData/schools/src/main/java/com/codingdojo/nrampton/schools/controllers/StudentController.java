package com.codingdojo.nrampton.schools.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.schools.models.Student;
import com.codingdojo.nrampton.schools.services.SchoolService;
import com.codingdojo.nrampton.schools.services.StudentPaginationService;
import com.codingdojo.nrampton.schools.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

		private StudentService studentService;
		private SchoolService schoolService;
		private StudentPaginationService _sps;
		
		public StudentController(StudentService studentService, SchoolService schoolService, StudentPaginationService _sps) {
			this.studentService = studentService;
			this.schoolService = schoolService;
			this._sps = _sps;
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
		
		@RequestMapping("/pages/{pageNumber}")
		public String getStudentsPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
			Page<Object[]> students = _sps.studentsPerPage(pageNumber - 1);
			int totalPages = students.getTotalPages();
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("students", students);
			return "students";
		}
		
		@RequestMapping("/theNuclearOption")
		public String theNuclearOption() {
			studentService.deleteAll();
			return "redirect:/";
		}
}
