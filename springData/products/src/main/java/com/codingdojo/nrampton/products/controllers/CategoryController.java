package com.codingdojo.nrampton.products.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.nrampton.products.models.Category;
import com.codingdojo.nrampton.products.models.Product;
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
	
	@RequestMapping("/{id}")
	public String displayCategory(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product product) {
		Category category = _cs.getCategoryById(id);
		List<Product> availableProducts = _cs.getAvailableProductsById(id);
		model.addAttribute("category", category);
		model.addAttribute("availableProducts", availableProducts);
		return "displayCategory";
	}
	
	@PostMapping("/appendProduct/{id}")
	public String appendProduct(@PathVariable("id") Long category_id, Model model, @ModelAttribute("product") Product product, BindingResult result) {
		_cs.appendProduct(category_id, product);
		return "redirect:/categories/" + category_id;
	}
	
	
	
	@RequestMapping("/theNuclearOption")
	public String theNuclearOption() {
		_cs.theNuclearOption();
		return "redirect:/";
	}
}
