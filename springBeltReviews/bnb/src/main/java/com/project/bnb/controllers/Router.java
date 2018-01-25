package com.project.bnb.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bnb.models.Pool;
import com.project.bnb.models.User;
import com.project.bnb.services.PoolService;
import com.project.bnb.services.ReviewService;
import com.project.bnb.services.UserService;
import com.project.bnb.validators.UserValidator;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	
	private UserService _us;
	private PoolService _ps;
	private ReviewService _rs;
	private UserValidator _uv;
	private BCryptPasswordEncoder _bcrypt;
	public Router(UserService _us, PoolService _ps, ReviewService _rs, UserValidator _uv) {
		super();
		this._us = _us;
		this._ps = _ps;
		this._rs = _rs;
		this._uv = _uv;
		this._bcrypt = new BCryptPasswordEncoder();
	}

	@RequestMapping("")									//getting to search page
	public String showSearch(HttpSession session, Model model){
		model.addAttribute("currentUser", _us.getUserById((Long) session.getAttribute("userId")));
		return "search";
	}
	
	@RequestMapping("/guest/signin")						//going to login/reg page
	public String showRegistration(@ModelAttribute("user") User user, HttpSession session) {
		session.invalidate();
		return "registration";
	}
	
	@RequestMapping("/search")										//displaying search results on a GET request
	public String showResults(@RequestParam("location") String searchTerm, Model model) {
		List<Pool> searchResults = _ps.searchPools(searchTerm.toLowerCase());
		model.addAttribute("results", searchResults);
		return "searchResults";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		_uv.validate(user, result);
		if (result.hasErrors()) {
			return "registration";
		}
		_us.createUser(user);
		session.setAttribute("userId", _us.getUserByEmail(user.getEmail()).getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		User user = _us.getUserByEmail(email);
		if (user == null || !_bcrypt.matches(password, user.getPassword())) {
			return "registration";
		}
		session.setAttribute("userId", user.getId());
		if (user.getLevel() < 1) {
			return "redirect:/";
		} else {
			return "redirect:/host/dashboard";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
