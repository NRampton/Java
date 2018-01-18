package com.codingdojo.nrampton.products.services;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.products.models.Category;
import com.codingdojo.nrampton.products.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository _cr;
	
	public CategoryService(CategoryRepository _cr) {
		this._cr = _cr;
	}
	
	public void createCategory(Category category) {
		_cr.save(category);
	}
}
