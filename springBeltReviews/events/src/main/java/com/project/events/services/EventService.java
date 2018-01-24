package com.project.events.services;

import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.events.repositories.EventRepository;

import com.project.events.models.User;
import com.project.events.models.Event;

@Service
public class EventService {
	// Member variables / service initializations go here
		
	private EventRepository _er;
	public EventService(EventRepository _er){
		super();
		this._er = _er;

	}
	
	public void createEvent(User host, Event event)  {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			event.setDate(format.parse(event.getSDate()));
		} catch(ParseException e) {
			e.printStackTrace();
		}
		event.setHost(host);
		_er.save(event);
	}

	public Event findOne(Long id) {
		return (Event) _er.findOne(id);
	}

	public List<Event> getAllEvents() {
		return (List<Event>) _er.findAll();
	}

	public void destroy(Long id) {
		Event event = _er.findOne(id);
		_er.delete(event);
	}

	public void addAttendee(Long id, User user) {
		Event event = _er.findOne(id);
		List<User> attendees = event.getAttendees();
		attendees.add(user);
		event.setAttendees(attendees);
		_er.save(event);
	}

	public void removeAttendee(Long id, User user) {
		Event event = _er.findOne(id);
		List<User> attendees = event.getAttendees();
		attendees.remove(user);
		event.setAttendees(attendees);
		_er.save(event);
	}

	public void updateEvent(Event event, User host) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			event.setDate(format.parse(event.getSDate()));
		} catch(ParseException e) {
			e.printStackTrace();
		}
		event.setHost(host);
		_er.save(event);
	}
}
