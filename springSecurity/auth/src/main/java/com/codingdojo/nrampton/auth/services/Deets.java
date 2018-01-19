package com.codingdojo.nrampton.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.auth.models.Role;
import com.codingdojo.nrampton.auth.models.User;
import com.codingdojo.nrampton.auth.repositories.UserRepository;

@Service
public class Deets implements UserDetailsService {
	private UserRepository _ur;
	
	public Deets(UserRepository _ur) {
		this._ur = _ur;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = _ur.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	
	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			GrantedAuthority gA = new SimpleGrantedAuthority(role.getName());
			authorities.add(gA);
		}
		return authorities;
	}
}
