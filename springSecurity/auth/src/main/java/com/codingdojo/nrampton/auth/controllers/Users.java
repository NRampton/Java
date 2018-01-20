package com.codingdojo.nrampton.auth.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.nrampton.auth.models.User;
import com.codingdojo.nrampton.auth.services.UserService;
import com.codingdojo.nrampton.auth.validator.UserValidator;

@Controller
public class Users {
	
	private UserService _us;
	private UserValidator _uv;
	
	public Users(UserService _us, UserValidator _uv) {
		this._us = _us;
		this._uv = _uv;
	}
	
	@RequestMapping("/registration")
	public String registrationForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		_uv.validate(user, result);
		if (result.hasErrors()) {
			return "registrationPage";
		}
		_us.saveUserWithUserRole(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid credentials. Please try again!");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout successful!");
		}
		return "loginPage";
	}
	
	@RequestMapping(value = {"/", "/home"})
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", _us.findByUsername(username));
		return "homePage";
	}
}
