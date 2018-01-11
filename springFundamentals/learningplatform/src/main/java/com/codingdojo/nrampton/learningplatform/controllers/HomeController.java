package com.codingdojo.nrampton.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	@RequestMapping("")
	public String displayDashboard() {
		return "lesson";
	}
	
	@RequestMapping("/m/{chapter}/0553/{id}")
	public String displayLesson(Model model, @PathVariable("chapter") String chapter, @PathVariable("id") String id) {
		if (id.equals("0733")) {
			model.addAttribute("placeholder", "Setting up Your servers");
		} else if (id.equals("0342")) {
			model.addAttribute("placeholder", "Punch Cards");
		} else if (id.equals("0348")) {
			model.addAttribute("placeholder", "Advanced Fortran Intro");
		} else {
			model.addAttribute("placeholder", null);
		}
		return "lesson";
	}
	
	@RequestMapping("/m/{chapter}/0483/{id}")
	public String displayAssignment(Model model, @PathVariable("chapter") String chapter, @PathVariable("id") String id) {
		if (id.equals("0345")) {
			model.addAttribute("placeholder", "Coding Forms");
		} else if (id.equals("2342")) {
			model.addAttribute("placeholder", "Fortran to Binary");
		} else {
			model.addAttribute("placeholder", null);
		}
		return "assignment";
	}
}

