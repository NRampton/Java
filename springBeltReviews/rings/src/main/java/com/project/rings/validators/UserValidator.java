package com.project.rings.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.rings.models.User;

@Component
public class UserValidator implements Validator{	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		if(!user.getPassword().equals(user.getConfirm())) {
			errors.rejectValue("confirm", "Match");
		}
		
		// Example:
		// if(!YourModel.getSomeField().equals(YourModel.getSomeOtherField())){
		// 	errors.rejectValue("someField","Match");
		// }
	}
}
