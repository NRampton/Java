package com.codingdojo.nrampton.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyHomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/submit")
	public String handleSubmission(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String renderResults(HttpSession session, Model model) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("location"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "showResults";
	}
}
