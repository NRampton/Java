package com.project.rings.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.rings.models.User;
import com.project.rings.repositories.UserRepo;

@Service
public class UserService {
	// Member variables / service initializations go here
	
	private BCryptPasswordEncoder _bcrypt;
	private UserRepo _ur;
		
	public UserService(UserRepo _ur){
		this._ur = _ur;
		this._bcrypt = new BCryptPasswordEncoder();

	}
	
	public void createUser(User user) {
		user.setPassword(_bcrypt.encode(user.getPassword()));
		if( ((List<User>) _ur.findAll()).size() == 0) {
			user.setLevel(1);
		} else {
			user.setLevel(0);
		}
		_ur.save(user);
	}
	
	public User getUserById(Long id) {
		return _ur.findOne(id);
	}
	
	public User getUserOnLogin(String username) {
		User user = _ur.findByEmail(username);
		if (user == null) {
			user = _ur.findByUsername(username);
		}
		return user;
	}
	
	public boolean checkUserPassword(User user, String rawPassword) {
		return (_bcrypt.matches(rawPassword, user.getPassword()));
	}
	
}
