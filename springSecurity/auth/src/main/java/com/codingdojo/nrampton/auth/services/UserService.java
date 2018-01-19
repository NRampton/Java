package com.codingdojo.nrampton.auth.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.auth.models.User;
import com.codingdojo.nrampton.auth.repositories.RoleRepository;
import com.codingdojo.nrampton.auth.repositories.UserRepository;

@Service
public class UserService {
	private RoleRepository _rr;
	private UserRepository _ur;
	private BCryptPasswordEncoder _bcrypt;
	public UserService(RoleRepository _rr, UserRepository _ur, BCryptPasswordEncoder _bcrypt) {
		super();
		this._rr = _rr;
		this._ur = _ur;
		this._bcrypt = _bcrypt;
	}
	
	public void saveUserWithUserRole(User user) {
		user.setPassword(_bcrypt.encode(user.getPassword()));
		user.setRoles(_rr.findByName("ROLE_USER"));
		_ur.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(_bcrypt.encode(user.getPassword()));
		user.setRoles(_rr.findByName("ROLE_ADMIN"));
		_ur.save(user);
	}
	
	public User findByUsername(String username) {
		return _ur.findByUsername(username);
	}
}
