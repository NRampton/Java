package com.project.events.validators;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// Replace occurences of "YourModel" with a valid model
import com.project.events.models.Event;

@Component
public class EventValidator implements Validator{	

	public EventValidator() {
		super();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Event.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Event event = (Event) object;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			event.setDate(format.parse(event.getsDate()));
		} catch(ParseException e) {
			e.printStackTrace();
		}
		Date today = new Date();
		System.out.println(today);
		System.out.println(event.getDate());
		if(event.getDate().before(today)) {
			System.out.println("Made it inside the if statement.");
			errors.rejectValue("date", "Before");
		}
	}
}
