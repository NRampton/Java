package com.codingdojo.nrampton.products.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="joints")
public class Joint {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	//constructor
	public Joint() {
		
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
