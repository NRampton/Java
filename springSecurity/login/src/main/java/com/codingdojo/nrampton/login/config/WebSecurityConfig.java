package com.codingdojo.nrampton.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.codingdojo.nrampton.login.services.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsServiceImplementation deets;
	
	

	public WebSecurityConfig(UserDetailsServiceImplementation deets) {
		super();
		this.deets = deets;
	}

	@Bean
	public BCryptPasswordEncoder _bcrypt() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/your_server/registration").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/your_server/login")
				.defaultSuccessUrl("/your_server/dashboard")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(deets).passwordEncoder(_bcrypt());
	}
}
