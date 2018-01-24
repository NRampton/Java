package com.project.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User{
	@Id
	@GeneratedValue
	private long id;
	@Size(min=1, message="First name cannot be blank")
	private String firstName;
	@Size(min=1, message="Last name cannot be blank")
	private String lastName;
	@Size(min=1, message="Location cannot be blank")
	private String location;
	@Size(min=2, max=2, message="Please use a valid state designation")
	private String state;
	@Email(message="Invalid email format! example: example@example.com")
	@Size(min=1, message="We'll be needing an email address for our secret nefarious database.")
	private String email;
	@Size(min=8, message="Password must be at least eight characters")
	private String password;
	@Transient
	private String confirm;	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
			name = "attendees_events", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<Event> events;
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Event> hostedEvents;

	@OneToMany(mappedBy="poster", fetch=FetchType.LAZY)
	private List<Message> comments;


	//handle createdAt and updatedAt
	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	

	//getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<Event> getHostedEvents() {
		return hostedEvents;
	}
	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}
	public List<Message> getComments() {
		return comments;
	}
	public void setComments(List<Message> comments) {
		this.comments = comments;
	}


	
	//constructor
	
	public User(){
		super();
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
