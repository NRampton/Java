package com.codingdojo.nrampton.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.login.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findUserByEmail(String email);
}
