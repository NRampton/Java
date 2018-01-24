package com.project.events.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.events.models.User;
import com.project.events.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository _ur;
	private BCryptPasswordEncoder _bcrypt;
		
	public UserService(UserRepository _ur){
		super();
		this._ur = _ur;
		this._bcrypt = new BCryptPasswordEncoder();
	}

	public boolean isMatch(String password, String dbPass) {
		if (_bcrypt.matches(password, dbPass)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void createUser(User user) {
		user.setPassword( _bcrypt.encode(user.getPassword()));
		_ur.save(user);
	}

	public ArrayList<User> getAllUsers() {
		return (ArrayList<User>) _ur.findAll();
	}

	public User findUserById(Long id) {
		return (User) _ur.findOne(id);
	}

	public User findUserByEmail(String email) {
		return (User) _ur.findByEmail(email);
	}

	public void updateUser(User user) {
		createUser(user);
	}

	public void destroy(User user) {
		_ur.delete(user);
	}
}
