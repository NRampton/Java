package com.codingdojo.nrampton.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.products.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
