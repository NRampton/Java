package com.codingdojo.nrampton.login.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.nrampton.login.models.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			errors.rejectValue("confirmPassword", "Match");
		}
	}
}
