package com.codingdojo.nrampton.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("EEEE 'the' dd 'of' MMMM ',' yyyy");
		Date date = new Date();
		model.addAttribute("date", format.format(date) );
		return "showDate";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		Date date = new Date();
		model.addAttribute("time", format.format(date));
		return "showTime";
	}
}
