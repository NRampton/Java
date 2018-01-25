package com.project.bnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bnb.models.Pool;
import com.project.bnb.models.Review;
import com.project.bnb.models.User;
import com.project.bnb.services.PoolService;
import com.project.bnb.services.ReviewService;
import com.project.bnb.services.UserService;

@Controller
@RequestMapping("/pools")
public class PoolController{
	//Member variables go here

	private UserService _us;
	private PoolService _ps;
	private ReviewService _rs;
	public PoolController(UserService _us, PoolService _ps, ReviewService _rs) {
		super();
		this._us = _us;
		this._ps = _ps;
		this._rs = _rs;
	}
	
	@RequestMapping("/{id}")
	public String showPool(Model model, @PathVariable("id") Long id){
		Pool currentPool = (Pool) _ps.getPoolById(id);
		model.addAttribute("currentPool", currentPool);
		return "displayPool";
	}
	
	@RequestMapping("/{id}/review")
	public String showReviewForm() {
		return "createReview";
	}
	
	@PostMapping("/new")
	public String createPool(HttpSession session, @Valid @ModelAttribute("pool") Pool pool, BindingResult result) {
		if (result.hasErrors()) {
			return "dashboard";
		}
		User currentUser = _us.getUserById((Long) session.getAttribute("userId"));
		_ps.createPool(pool, currentUser);
		return "redirect:/host/dashboard";
	}
	
	@RequestMapping("/{id}")
	public String displayPool(Model model, @Valid @ModelAttribute("review") Review review, HttpSession session, @PathVariable("id") Long id) {
		User currentUser = _us.getUserById((Long) session.getAttribute("userId"));
		model.addAttribute("currentUser", currentUser);
		Pool currentPool = _ps.getPoolById(id);
		if (currentPool == null) {
			return "redirect:/";
		}	
		model.addAttribute("currentPool", currentPool);
		return "displayPool";
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePool(HttpSession session, @PathVariable("id") Long id) {
		User currentUser = _us.getUserById((Long) session.getAttribute("userId"));
		Pool currentPool = _ps.getPoolById(id);
		if (currentPool.getHost().getId() == currentUser.getId()) {
			_ps.deletePool(id);
			return "redirect:/host/dashboard";
		}
		return "redirect:/host/dashboard";
	}
	
	@PostMapping("/edit/{id}")
	public String updatePool(@Valid @ModelAttribute("pool") Pool currentPool, BindingResult result) {
		if (result.hasErrors()) {
			return "editPool";
		}
		_ps.updatePool(currentPool);
		return "redirect:/host/dashboard";
	}
	
	
}
