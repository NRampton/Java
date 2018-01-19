package com.codingdojo.nrampton.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.nrampton.login.models.User;
import com.codingdojo.nrampton.login.services.UserService;
import com.codingdojo.nrampton.login.validator.UserValidator;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	private UserService _us;
	private UserValidator _uv;
	
	public HomeController(UserService _us, UserValidator _uv) {
		this._us = _us;
		this._uv = _uv;
	}
	
	@RequestMapping(value= {"/", "/login"})
	public String showLandingPage(@Valid @ModelAttribute("newUser") User newUser, Model model) {
		return "landingPage";
	}
	
	@PostMapping("/login")
	public String login() {
		return "success";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session, RedirectAttributes rA) {
		_uv.validate(newUser, result);
		if (result.hasErrors()) {
			return "landingPage";
		}
		if (_us.saveUser(newUser)) {
			rA.addFlashAttribute("successMessage", "Yay, you're registered. Now login and prove it.");
			return "redirect:/your_server/login";		
		} else {
			rA.addFlashAttribute("failureMessage", "That email address is already taken. Have you been here before? Anyway, pick a new email.");
			return "redirect:/your_server/login";		
		}
	}
	
	
	
	
	
	@RequestMapping("/theNuclearOption/noSeriously")
	public String theNuclearOption() {
		_us.theNuclearOption();
		return "redirect:/your_server/login";
	}
}
