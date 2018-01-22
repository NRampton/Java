package com.project.login.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.login.models.User;
import com.project.login.services.UserService;

@Controller
public class UserController{
	private UserService _us;
	private BCryptPasswordEncoder _bcrypt;

	public UserController(UserService _us) {
		this._us = _us;		
		this._bcrypt = new BCryptPasswordEncoder();
	}
	
	@RequestMapping("/register")
	public String register(Model model, @ModelAttribute("user") User user, HttpSession session) {
		session.invalidate();
		return "register";
	}	

	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "register";
		} else {
			_us.createUser(user);
			session.setAttribute("id", user.getId());
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/dashboard")
	public String showDashboard(HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "dashboard";			
		} else {
			return "redirect:/register";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		return "redirect:/register";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {
		User user = _us.findUserByEmail(email);
		if (user == null) {
			return "redirect:/registration";
		} else {
			if (_us.isMatch(password, user.getPassword())) {
				session.setAttribute("id", user.getId());
				return "redirect:/dashboard";
			} else {
				return "redirect:/register";
			}
		}
	}
}
