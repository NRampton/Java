package com.project.rings.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.rings.models.Ring;
import com.project.rings.models.User;
import com.project.rings.services.CompanyService;
import com.project.rings.services.RingService;
import com.project.rings.services.UserService;
import com.project.rings.validators.UserValidator;

@Controller
public class RingController{
	//Member variables go here

	private UserService _us;
	private RingService _rs;
	private CompanyService _cs;
	private UserValidator _uv;
	
	
	public RingController(UserService _us, RingService _rs, CompanyService _cs, UserValidator _uv) {
		super();
		this._us = _us;
		this._rs = _rs;
		this._cs = _cs;
		this._uv = _uv;
	}


	@RequestMapping("/bind_in_darkness")
	public String showDashboard(HttpSession session, Model model){
		User currentUser = _us.getUserById((Long) session.getAttribute("id"));
		if (currentUser == null) {
			return "redirect:/";
		}
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("availableRings", _rs.getAvailableRings());		
		return "ringDashboard";
	}	
	
	@RequestMapping("ring_creator")
	public String showRingCreator(@ModelAttribute("ring") Ring ring, HttpSession session) {
		return "ringCreator";
	}
}
