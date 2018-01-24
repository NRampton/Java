package com.project.bnb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bnb.models.User;
import com.project.bnb.services.PoolService;
import com.project.bnb.services.ReviewService;
import com.project.bnb.services.UserService;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	
	private UserService _us;
	private PoolService _ps;
	private ReviewService _rs;
	public Router(UserService _us, PoolService _ps, ReviewService _rs) {
		super();
		this._us = _us;
		this._ps = _ps;
		this._rs = _rs;
	}

	@RequestMapping("")									//getting to search page
	public String showSearch(HttpSession session, Model model){
		model.addAttribute("user", session.getAttribute("user"));
		return "search";
	}
	
	@RequestMapping("/guest/signin")						//going to login/reg page
	public String showRegistration(@ModelAttribute("user") User user) {
		return "registration";
	}
	
	@RequestMapping("/{location}")										//displaying search results on a GET request
	public String showResults(@PathVariable("searchTerm") String searchTerm) {
		return "searchResults";
	}
}
