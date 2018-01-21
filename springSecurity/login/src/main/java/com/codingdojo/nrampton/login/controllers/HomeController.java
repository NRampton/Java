package com.codingdojo.nrampton.login.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.nrampton.login.models.Role;
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
	public String showLandingPage(@Valid @ModelAttribute("newUser") User newUser, Model model, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout) {
		if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
		return "landingPage";
	}
	
//	@PostMapping("/login")
//	public String login() {
//		return "success";
//	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session, RedirectAttributes rA) {
		_uv.validate(newUser, result);
		if (result.hasErrors()) {
			return "landingPage";
		}
		if (_us.saveUser(newUser)) {
			for (Role role : newUser.getRoles()) {
				if (role.getName().equals("ROLE_ADMIN")) {
					rA.addFlashAttribute("successMessage", "Yay, you're registered, and the Sorting Hat put you in the House of Admin. Now login and prove it.");
					return "redirect:/your_server/login";
				}
			}
			rA.addFlashAttribute("successMessage", "Yay, you're registered. Now login and prove it.");
			return "redirect:/your_server/login";		
		} else {
			rA.addFlashAttribute("failureMessage", "That email address is already taken. Have you been here before? Anyway, pick a new email.");
			return "redirect:/your_server/login";		
		}
	}
	
	@RequestMapping("/dashboard")
	public String showDashboard(Principal principal, Model model) {
		String email = principal.getName();
		User currentUser = _us.getUserByEmailWithUpdatedLogin(email);
		for (Role role : currentUser.getRoles()) {
			if (role.getName().equals("ROLE_ADMIN")) {
				return "redirect:/your_server/admin";
			}
		}
		SimpleDateFormat frmt = new SimpleDateFormat("MMMM dd, yyyy");
		SimpleDateFormat frmtWithTime = new SimpleDateFormat("MMMM dd, yyyy 'at' HH:mm a");
		model.addAttribute("createdAt", frmt.format(currentUser.getCreatedAt()));
		model.addAttribute("updatedAt", frmtWithTime.format(currentUser.getUpdatedAt()));
		model.addAttribute("currentUser", currentUser);
		return "success";
	}
	
	@RequestMapping("/admin")
	public String showAdminDashboard(Principal principal, Model model) {
		String email = principal.getName();
		model.addAttribute("users", _us.getAllUsers());
		model.addAttribute("currentUser", _us.findUserByEmail(email));
		return "adminPage";
	}
	
	@RequestMapping("/admin/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		_us.deleteUserById(id);
		return "redirect:/your_server/admin";
	}
	
	@RequestMapping("admin/makeAdmin/{id}")
	public String makeAdmin(@PathVariable("id") Long id) {
		_us.makeUserAnAdmin(id);
		return "redirect:/your_server/admin";
	}
	
	
	
	@RequestMapping("/theNuclearOption/noSeriously")
	public String theNuclearOption() {
		_us.theNuclearOption();
		return "redirect:/your_server/login";
	}
}
