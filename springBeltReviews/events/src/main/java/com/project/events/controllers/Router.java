package com.project.events.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	public Router(){
		super();
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req, HttpSession session){	
		String url = req.getRequestURI().toString();
		if(session.getAttribute("id") != null) {
			return "redirect:/dashboard";
		}	else {
		return "redirect:/register";
		}
	}		
}
