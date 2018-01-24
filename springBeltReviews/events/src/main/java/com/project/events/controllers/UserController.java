package com.project.events.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.events.models.User;
import com.project.events.models.Event;
import com.project.events.models.Message;
import com.project.events.services.UserService;
import com.project.events.services.EventService;
import com.project.events.services.MessageService;
import com.project.events.validators.UserValidator;
import com.project.events.validators.EventValidator;

@Controller
public class UserController{
	private UserService _us;
	EventService _es;
	MessageService _ms;
	private BCryptPasswordEncoder _bcrypt;
	private UserValidator _uv;
	private EventValidator _ev;

	public UserController(UserService _us, EventService _es, MessageService _ms, UserValidator _uv, EventValidator _ev) {
		super();
		this._us = _us;		
		this._ms = _ms;
		this._es = _es;
		this._bcrypt = new BCryptPasswordEncoder();
		this._uv = _uv;
		this._ev = _ev;
	}
	
	@RequestMapping("/register")
	public String register(Model model, @ModelAttribute("user") User user, HttpSession session) {
		session.invalidate();
		return "register";
	}	
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		System.out.println(user.toString());
		_uv.validate(user, result);
		if (result.hasErrors()) {
			return "register";
		} else {
			_us.createUser(user);
			session.setAttribute("id", user.getId());
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/dashboard")
	public String showDashboard(Model model, HttpSession session, @ModelAttribute("event") Event event) {
		if (session.getAttribute("id") != null) {
			User user = _us.findUserById((Long) session.getAttribute("id"));
			model.addAttribute("user", user);
			List<Event> allEvents = _es.getAllEvents();
			List<Event> inState = new ArrayList<>();
			List<Event> outOfState = new ArrayList<>();
			for (Event iEvent : allEvents) {
				if(iEvent.getState().equals(user.getState())) {
					inState.add(iEvent);
				} else {
					outOfState.add(iEvent);
				}
			}
			model.addAttribute("inState", inState);
			model.addAttribute("outOfState", outOfState);
			return "dashboard";
		} else {
			return "redirect:/register";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		return "redirect:/register";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {
		User user = _us.findUserByEmail(email);
		System.out.println("Here's the user we found: " + user.getFirstName());
		if (user == null) {
			return "redirect:/registration";
		} else {
			if (_us.isMatch(password, user.getPassword())) {
				System.out.println(_us.isMatch(password, user.getPassword()));
				session.setAttribute("id", user.getId());
				System.out.println("User in session has the following ID: " + session.getAttribute("id"));
				return "redirect:/dashboard";
			} else {
				return "redirect:/register";
			}
		}
	}

	@PostMapping("/events")
	public String createEvent(HttpSession session, @Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		System.out.println(event);
		_ev.validate(event, result);
		if (result.hasErrors()) {
			if (session.getAttribute("id") != null) {
				User user = _us.findUserById((Long) session.getAttribute("id"));
				model.addAttribute("user", user);
				List<Event> allEvents = _es.getAllEvents();
				List<Event> inState = new ArrayList<>();
				List<Event> outOfState = new ArrayList<>();
				for (Event iEvent : allEvents) {
					if(iEvent.getState().equals(user.getState())) {
						inState.add(iEvent);
					} else {
						outOfState.add(iEvent);
					}
				}
				model.addAttribute("inState", inState);
				model.addAttribute("outOfState", outOfState);	
				return "dashboard";			
			}		
		}
		User host = _us.findUserById((Long) session.getAttribute("id"));
		_es.createEvent(host, event);
		return "redirect:/dashboard";
	}

	@RequestMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id") Long id) {
		_es.destroy(id);
		return "redirect:/dashboard";
	}

	@RequestMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		User currentUser = _us.findUserById((Long) session.getAttribute("id"));
		_es.addAttendee(id, currentUser);
		return "redirect:/dashboard";
	}

	@RequestMapping("/events/{id}/cancel")
	public String cancelEvent(@PathVariable("id") Long id, HttpSession session) {
		User currentUser = _us.findUserById((Long) session.getAttribute("id"));
		_es.removeAttendee(id, currentUser);
		return "redirect:/dashboard";
	}

	@RequestMapping("/events/{id}/edit")
	public String showEditEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
		User currentUser = _us.findUserById((Long) session.getAttribute("id"));
		Event currentEvent = _es.findOne(id);
		if (!currentEvent.getHost().equals(currentUser)) {
			return "redirect:/";
		}
		model.addAttribute("event", currentEvent);
		return "editEvent";
	}

	@PostMapping("/events/{id}/edit")
	public String editEvent(@ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
		User host = _us.findUserById((Long) session.getAttribute("id"));
		_es.updateEvent(event, host);
		return "redirect:/dashboard";
	}

	@RequestMapping("events/{id}")
	public String showEvent(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("message") Message message) {
		Event currentEvent = _es.findOne(id);
		model.addAttribute("event", currentEvent);
		return "displayEvent";
	}

	@PostMapping("/events/{id}/message")
	public String createMessage(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("message") Message message, BindingResult result) {
		User commenter = _us.findUserById((Long) session.getAttribute("id"));
		_ms.createMessage(id, commenter, message);
		return "redirect:/events/" + id;
	}
}
