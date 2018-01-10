package com.codingdojo.nrampton.outputdate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		SimpleDateFormat dateFrmt = new SimpleDateFormat("EEEE', the 'd' of 'MMMM', 'yyyy");
		Date today = new Date();
		model.addAttribute("date", dateFrmt.format(today));
		return "dateDisplay.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		SimpleDateFormat timeFrmt = new SimpleDateFormat("h:mm a");
		Date today = new Date();
		model.addAttribute("time", timeFrmt.format(today));
		return "timeDisplay.jsp";
	}
}
