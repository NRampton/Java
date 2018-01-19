package com.codingdojo.nrampton.login.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.login.models.User;
import com.codingdojo.nrampton.login.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository _ur;
	
	public UserService(UserRepository _ur) {
		this._ur = _ur;
	}
	
	public boolean saveUser(User newUser) {
		List<User> allUsers = (List<User>) _ur.findAll();
		for (User user : allUsers ) {
			if (user.getEmail().equals(newUser.getEmail())) {
				return false;
			}
		}
		_ur.save(newUser);
		return true;
	}
	
	
	public void theNuclearOption() {
		_ur.deleteAll();
	}
}
