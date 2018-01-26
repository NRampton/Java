package com.project.rings.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User{
	
	//Fields
	@Id
	@GeneratedValue
	private long id;

	@Size(min=1)
	private String username;
	@Email()
	@Size(min=1)	
	private String email;
	@Size(min=8)
	private String password;
	
	private int level;
	
	@Transient
	private String confirm;
	
	private Date lastPickUp;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	@OneToMany(mappedBy="smith", fetch=FetchType.LAZY)
	private List<Ring> forgedRings;
	
	@OneToMany(mappedBy="bearer", fetch=FetchType.LAZY)
	private List<Ring> bornRings;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="users_companies",
		joinColumns=@JoinColumn(name="user_id"), 
		inverseJoinColumns=@JoinColumn(name="company_id")
	)
	private List<Company> companies;
	
	
	
	//created-/updatedAt
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
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastPickUp() {
		return lastPickUp;
	}
	public void setLastPickUp(Date lastPickUp) {
		this.lastPickUp = lastPickUp;
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
	public List<Ring> getForgedRings() {
		return forgedRings;
	}
	public void setForgedRings(List<Ring> forgedRings) {
		this.forgedRings = forgedRings;
	}
	public List<Ring> getBornRings() {
		return bornRings;
	}
	public void setBornRings(List<Ring> bornRings) {
		this.bornRings = bornRings;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	//constructors
	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
