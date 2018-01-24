package com.project.bnb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showPool(){
		return "displayPool";
	}
	
	@RequestMapping("/{id}/review")
	public String showReviewForm() {
		return "createReview";
	}
}
