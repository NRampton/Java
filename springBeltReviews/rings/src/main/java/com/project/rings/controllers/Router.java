package com.project.rings.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.rings.models.User;
import com.project.rings.services.CompanyService;
import com.project.rings.services.RingService;
import com.project.rings.services.UserService;
import com.project.rings.validators.UserValidator;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	
	private UserService _us;
	private RingService _rs;
	private CompanyService _cs;
	private UserValidator _uv;
	

	public Router(UserService _us, RingService _rs, CompanyService _cs, UserValidator _uv) {
		super();
		this._us = _us;
		this._rs = _rs;
		this._cs = _cs;
		this._uv = _uv;
	}

	@RequestMapping("index")
	public String index(@ModelAttribute("user") User user, HttpSession session){
		session.invalidate();
		return "register";
	}

	@RequestMapping("")
	public String redirectToRegistration(HttpServletRequest req){		
		return "redirect:/index";
	}		
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		_uv.validate(user, result);
		if (result.hasErrors()) {
			return "register";
		}
		_us.createUser(user);
		session.setAttribute("id", user.getId());
		return "redirect:/bind_in_darkness";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes rA, HttpSession session) {
		User user = _us.getUserOnLogin(username);
		if(user == null) {
			rA.addFlashAttribute("error", "Invalid credentials.");
			session.invalidate();
			return "redirect:/index";
		}
		if (_us.checkUserPassword(user, password)) {
			session.setAttribute("id", user.getId());	
			return "redirect:/bind_in_darkness";
		}
		rA.addFlashAttribute("error", "Invalid credentials.");
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
}
