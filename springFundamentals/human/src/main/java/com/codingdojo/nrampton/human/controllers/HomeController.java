package com.codingdojo.nrampton.human.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	@RequestMapping("")
	public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="lname", required=false) String lname, Model model) {
		if (name != null) {
			model.addAttribute("name", name);
		} else {
			model.addAttribute("name", "Human");
		}
		if (lname != null) {
			model.addAttribute("lname", lname);
		} else {
			model.addAttribute("lname", "being");
		}
		return "index";
	}
}
