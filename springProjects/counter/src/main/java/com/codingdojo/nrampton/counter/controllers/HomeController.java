package com.codingdojo.nrampton.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/your_server")
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("counter", 0);
		} 
		Integer count = (Integer) session.getAttribute("counter");
		count += 1;
		session.setAttribute("counter", count);
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model) {
		if (session.isNew()) {
			session.setAttribute("counter", 0);
		}
		model.addAttribute("counter", session.getAttribute("counter"));
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCounter(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
}
