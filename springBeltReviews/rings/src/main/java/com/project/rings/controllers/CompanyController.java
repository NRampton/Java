package com.project.rings.controllers;

import org.springframework.stereotype.Controller;

import com.project.rings.services.CompanyService;
import com.project.rings.services.UserService;

@Controller
public class CompanyController{
	
	private UserService _us;
	private CompanyService _cs;
	
	
	
	public CompanyController(UserService _us, CompanyService _cs) {
		super();
		this._us = _us;
		this._cs = _cs;
	}
	
}
