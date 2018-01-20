package com.codingdojo.nrampton.login.services;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.login.models.User;
import com.codingdojo.nrampton.login.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository _ur;
	private BCryptPasswordEncoder _bcrypt;
	
	public UserService(UserRepository _ur, BCryptPasswordEncoder _bcrypt) {
		this._ur = _ur;
		this._bcrypt = _bcrypt;
	}
	
	public boolean saveUser(User newUser) {
		List<User> allUsers = (List<User>) _ur.findAll();
		for (User user : allUsers ) {
			if (user.getEmail().equals(newUser.getEmail())) {
				return false;
			}
		}
		newUser.setPassword(_bcrypt.encode(newUser.getPassword()));		
		_ur.save(newUser);
		return true;
	}
	
	public User findUserByEmail(String email) {
		return _ur.findUserByEmail(email);
	}
	
	public User getUserByEmailWithUpdatedLogin(String email) {
		User user = findUserByEmail(email);
		user.setUpdatedAt(new Date());
		return _ur.save(user);
	}
	
	
	public void theNuclearOption() {
		_ur.deleteAll();
	}
}
