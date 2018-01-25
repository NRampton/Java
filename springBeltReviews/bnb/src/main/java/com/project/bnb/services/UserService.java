package com.project.bnb.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.bnb.models.Pool;
import com.project.bnb.models.User;
import com.project.bnb.repositories.UserRepository;

@Service
public class UserService {
	// Member variables / service initializations go here
		
	private UserRepository _ur;
	private BCryptPasswordEncoder _bcrypt;

	public UserService(UserRepository _ur) {
		super();
		this._ur = _ur;
		this._bcrypt = new BCryptPasswordEncoder();
	}
	
	public User getUserById(Long id) {
		return (User) _ur.findOne(id);
	}
	
	public User getUserByEmail(String email) {
		return (User) _ur.findByEmail(email);
	}
	
	public void createUser(User user) {
		user.setPassword(_bcrypt.encode(user.getPassword()));
		_ur.save(user);
	}
	
}
