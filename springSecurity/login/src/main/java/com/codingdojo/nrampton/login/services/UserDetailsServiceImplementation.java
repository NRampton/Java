package com.codingdojo.nrampton.login.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.login.models.User;
import com.codingdojo.nrampton.login.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	private UserRepository _ur;

	public UserDetailsServiceImplementation(UserRepository _ur) {
		super();
		this._ur = _ur;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = _ur.findUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities());
	}
	
	private List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("anything");
		authorities.add(grantedAuthority);
		return authorities;
	}
}
