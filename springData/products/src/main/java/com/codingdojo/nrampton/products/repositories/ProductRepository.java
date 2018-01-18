package com.codingdojo.nrampton.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
