package com.codingdojo.nrampton.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		return "index";
	}
	
	@RequestMapping(path="/guess", method=RequestMethod.POST)
	public String takeAGuess(@RequestParam(value="guess") String guess,RedirectAttributes redirectAttributes) {
		if (guess.equals("bushido")) {
			return "redirect:/code";
		}
		redirectAttributes.addFlashAttribute("errors", "You must train harder!");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String showCode() {
		return "thecode";
	}
}
