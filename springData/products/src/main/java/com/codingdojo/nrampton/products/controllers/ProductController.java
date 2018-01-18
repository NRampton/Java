package com.codingdojo.nrampton.products.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.products.models.Category;
import com.codingdojo.nrampton.products.models.Product;
import com.codingdojo.nrampton.products.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private ProductService _ps;
	
	
	public ProductController(ProductService _ps) {
		this._ps = _ps;
	}
	
	@RequestMapping("/new")
	public String showProductForm(@ModelAttribute("product") Product product, Model model) {
		return "productForm";
	}
	
	@PostMapping("/new")
	public String addProduct(@ModelAttribute("product") Product product, BindingResult result, Model model) {
		_ps.createProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String displayProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category category) {
		Product product = _ps.getProductById(id);
		List<Category> availableCategories = _ps.getAvailableCategoriesById(id);
		model.addAttribute("product", product);
		model.addAttribute("availableCategories", availableCategories);
		return "displayProduct";
	}
	
	@PostMapping("/appendCategory/{id}")
	public String appendCategory(@PathVariable("id") Long product_id, Model model, @ModelAttribute("category") Category category, BindingResult result) {
		_ps.appendCategory(product_id, category);
		return "redirect:/products/" + product_id;
	}
	
	
	
	@RequestMapping("/theNuclearOption")
	public String theNuclearOption() {
		_ps.deleteAll();
		return "redirect:/";
	}
}
