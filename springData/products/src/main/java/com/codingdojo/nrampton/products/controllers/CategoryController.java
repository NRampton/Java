package com.codingdojo.nrampton.products.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.nrampton.products.models.Category;
import com.codingdojo.nrampton.products.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	private CategoryService _cs;
	
	public CategoryController(CategoryService _cs) {
		this._cs = _cs;
	}
	
	@RequestMapping("/new")
	public String showCategoryForm(Model model, @ModelAttribute("category") Category category) {
		return "categoryForm";
	}
	
	@PostMapping("/new")
	public String addCategory(@RequestParam("name") String name) {
		Category category = new Category(name);
		_cs.createCategory(category);
		return "redirect:/";
	}
}
