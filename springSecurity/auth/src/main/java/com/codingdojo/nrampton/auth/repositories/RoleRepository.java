package com.codingdojo.nrampton.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.auth.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	public List<Role> findByName(String name);
	public List<Role> findAll();
}
