package com.codingdojo.nrampton.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.login.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	public Role findByName(String name);
}
