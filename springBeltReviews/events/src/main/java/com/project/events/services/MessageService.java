package com.project.events.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.events.repositories.MessageRepository;
import com.project.events.services.EventService;

import com.project.events.models.User;
import com.project.events.models.Event;
import com.project.events.models.Message;

@Service
public class MessageService {

		private MessageRepository _mr;
		private EventService _es;
	public MessageService(MessageRepository _mr, EventService _es){
		super();
		this._mr = _mr;
		this._es = _es;
	}
	
	public void createMessage(Long id, User commenter, Message message) {
		Event currentEvent = _es.findOne(id);
		message.setPoster(commenter);
		message.setSubject(currentEvent);
		_mr.save(message);
	}

}
