package com.codingdojo.nrampton.products.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	@RequestMapping("/theNuclearOption")
	public String theNuclearOption() {
		_ps.deleteAll();
		return "redirect:/";
	}

}
