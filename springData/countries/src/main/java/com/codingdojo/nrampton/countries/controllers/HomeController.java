package com.codingdojo.nrampton.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.countries.services.ApiService;

@Controller
public class HomeController {
	
	private ApiService _as;
	
	public HomeController(ApiService _as) {
		this._as = _as;
	}
	@RequestMapping("/")
	public String showResults() {
		return "results";
	}
}
