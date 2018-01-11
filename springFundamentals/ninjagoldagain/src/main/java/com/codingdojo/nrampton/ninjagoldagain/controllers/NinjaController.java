package com.codingdojo.nrampton.ninjagoldagain.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class NinjaController {
	@RequestMapping("")
	public String showIndex(HttpSession session, Model model) {
		if (session.isNew()) {
			session.setAttribute("gold", 0);
			session.setAttribute("log", new ArrayList<String>());
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("log", session.getAttribute("log"));
		return "index.jsp";
	}
	
	@RequestMapping("/process")
	public String process(HttpSession session, @RequestParam(value="location") String location) {
		Random rand = new Random();
		int delta;
		if (location.equals("farm")) { 				//10-20
			delta = rand.nextInt(11) + 10;			
		} else if (location.equals("cave")){			//5-10
			delta =  rand.nextInt(6) + 5;
		} else if (location.equals("house")) {		//2-5	
			delta =  rand.nextInt(4) + 2;
		} else {										//-50-50
			delta =  rand.nextInt(101) -50;
		}
		session.setAttribute("gold", ((int) session.getAttribute("gold") + delta));
		ArrayList<String> logTemp = (ArrayList<String>) session.getAttribute("log");
		logTemp.add(0, "You visited the " + location + ", and your gold changed by " + delta +".");
		session.setAttribute("log", logTemp);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String resetGold(HttpSession session) {
		session.invalidate();
		ArrayList<String> hello = new ArrayList<String>();
		return "redirect:/";
		
	}
	
	
}
