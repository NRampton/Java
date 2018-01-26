package com.project.rings.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/ring_creator")
	public String showRingCreator(@ModelAttribute("ring") Ring ring, HttpSession session) {
		return "ringCreator";
	}
	
	@PostMapping("/rings/new")
	public String createRing(HttpSession session, @RequestParam("name") String name) {
		User user = _us.getUserById((Long) session.getAttribute("id"));
		_rs.forgeRing(name, user);
		return "redirect:/bind_in_darkness";
	}
	
	@PostMapping("rings/claim")
	public String claimRing(HttpSession session, @RequestParam("chosenRing") Ring ring, RedirectAttributes rA) {
		User user = _us.getUserById((Long) session.getAttribute("id"));
		if(user.getLastPickUp() == null) {
			_rs.claimRing(ring, user);
			return "redirect:/bind_in_darkness";
		}
		Date now = new Date();
		if ((now.getTime() - user.getLastPickUp().getTime()) < 300000 ) {
			rA.addFlashAttribute("claimError", "Your too-greedy hand will be your downfall! Stay, and play a little more with those baubles of power you already possess.");
			return "redirect:/bind_in_darkness";
		}
		_rs.claimRing(ring, user);
		return "redirect:/bind_in_darkness";
	}
	
	@RequestMapping("/rings/{id}/lose")
	public String loseRing(@PathVariable("id") Long id, HttpSession session) {
		User user = _us.getUserById((Long) session.getAttribute("id"));
		_rs.loseRing(id);
		return "redirect:/bind_in_darkness";
	}
}
