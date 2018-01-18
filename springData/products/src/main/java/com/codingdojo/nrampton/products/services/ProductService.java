package com.codingdojo.nrampton.products.services;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.products.models.Product;
import com.codingdojo.nrampton.products.repositories.ProductRepository;

@Service
public class ProductService {

	private ProductRepository _pr;
	
	public ProductService(ProductRepository _pr) {
		this._pr = _pr;
	}
	
	public void createProduct(Product product) {
		_pr.save(product);
	}
	
	
	public void deleteAll() {
		_pr.deleteAll();
	}
}
