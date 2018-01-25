package com.project.bnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bnb.models.Pool;
import com.project.bnb.models.User;
import com.project.bnb.services.PoolService;
import com.project.bnb.services.ReviewService;
import com.project.bnb.services.UserService;

@Controller
@RequestMapping("/host")
public class HostController{
	//Member variables go here

	private UserService _us;
	private PoolService _ps;
	private ReviewService _rs;
	public HostController(UserService _us, PoolService _ps, ReviewService _rs) {
		super();
		this._us = _us;
		this._ps = _ps;
		this._rs = _rs;
	}
	
	@RequestMapping("/dashboard")
	public String showDashboard(HttpSession session, @Valid @ModelAttribute("pool") Pool pool, Model model) {
		User currentUser = _us.getUserById((Long) session.getAttribute("userId"));
		if (currentUser == null || currentUser.getLevel() < 1) {
			return "redirect:/";
		}
		model.addAttribute("currentUser", currentUser);
		return "dashboard";
	}
	
	@RequestMapping("/pools/{id}")
	public String showEditPoolForm(@PathVariable("id") Long id, Model model) {
		Pool currentPool = _ps.getPoolById(id);
		model.addAttribute("pool", currentPool);
		return "editPool";
	}
}
