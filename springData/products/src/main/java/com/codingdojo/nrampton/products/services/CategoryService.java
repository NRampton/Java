package com.codingdojo.nrampton.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.products.models.Category;
import com.codingdojo.nrampton.products.models.Joint;
import com.codingdojo.nrampton.products.models.Product;
import com.codingdojo.nrampton.products.repositories.CategoryRepository;
import com.codingdojo.nrampton.products.repositories.JointRepository;
import com.codingdojo.nrampton.products.repositories.ProductRepository;

@Service
public class CategoryService {

	private CategoryRepository _cr;
	private ProductRepository _pr;
	private JointRepository _jr;
	
	public CategoryService(CategoryRepository _cr, ProductRepository _pr, JointRepository _jr) {
		this._cr = _cr;
		this._pr = _pr;
		this._jr = _jr;
	}
	
	public void createCategory(Category category) {
		_cr.save(category);
	}
	
	public Category getCategoryById(Long id) {
		return _cr.findOne(id);
	}
	
	public List<Product> getAvailableProductsById(Long id) {
		List<Product> availableProds = (List<Product>) _pr.findAll();
		Category category = _cr.findOne(id);
		for (Joint joint: category.getJoints()) {
			availableProds.remove(joint.getProduct());
		}
		return availableProds;
	}
	
	public void appendProduct(Long category_id, Product product) {
		Joint newJoint = new Joint(product, _cr.findOne(category_id));
		_jr.save(newJoint);
	}
	
	
	public void theNuclearOption() {
		_cr.deleteAll();
	}
}
