package com.codingdojo.nrampton.login.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.login.models.Role;
import com.codingdojo.nrampton.login.models.User;
import com.codingdojo.nrampton.login.repositories.RoleRepository;
import com.codingdojo.nrampton.login.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository _ur;
	private BCryptPasswordEncoder _bcrypt;
	private RoleRepository _rr;
	
	public UserService(UserRepository _ur, BCryptPasswordEncoder _bcrypt, RoleRepository _rr) {
		this._ur = _ur;
		this._bcrypt = _bcrypt;
		this._rr = _rr;
	}
	
	public List<User> getAllUsers() {
		return (List<User>) _ur.findAll();
	}
	
	public boolean saveUser(User newUser) {
		List<User> allUsers = (List<User>) _ur.findAll();
		for (User user : allUsers ) {
			if (user.getEmail().equals(newUser.getEmail())) {
				return false;
			}
		}
		if (!thereIsAnAdmin()) {
			List<Role> roles = new ArrayList<Role>();
			roles.add(_rr.findByName("ROLE_ADMIN"));
			newUser.setRoles(roles);
			newUser.setPassword(_bcrypt.encode(newUser.getPassword()));
			_ur.save(newUser);
			return true;
		}
		List<Role> roles = new ArrayList<Role>();
		roles.add(_rr.findByName("ROLE_USER"));
		newUser.setPassword(_bcrypt.encode(newUser.getPassword()));
		newUser.setRoles(roles);
		_ur.save(newUser);
		return true;
	}
	
	public boolean thereIsAnAdmin() {
		List<User> allUsers = (List<User>) _ur.findAll();
		for (User user : allUsers) {
			for (Role role : user.getRoles()) {
				if (role.getName().equals("ROLE_ADMIN")) {
					return true;
				}
			}
		}
		return false;		
	}
	
	public void deleteUserById(Long id) {
		_ur.delete(id);
	}
	
	public void makeUserAnAdmin(Long id) {
		User user = _ur.findOne(id);
		List<Role> roles = user.getRoles();
		roles.add(_rr.findByName("ROLE_ADMIN"));
		user.setRoles(roles);
		_ur.save(user);
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
