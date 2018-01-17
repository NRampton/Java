package com.codingdojo.nrampton.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	
	private static Integer counter = 1;
	
	@Id
	@GeneratedValue
	private Long id;
	private String number;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiration_date;
	private String state;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	
	//Constructors
	public License() {
		
	}
	
	//handle createdAt and updatedAt
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
	
	

	//getters and setters
	public static Integer getCounter() {
		return counter;
	}
	
	public Long getId() {
		return id;
	}


	public String getNumber() {
		return number;
	}


	public Date getExpiration_date() {
		return expiration_date;
	}


	public String getState() {
		return state;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public Person getPerson() {
		return person;
	}

	public static void setCounter(Integer counter) {
		License.counter = counter;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

}
