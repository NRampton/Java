package com.codingdojo.nrampton.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Song {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	@Size(min=5, message="Song title must be at least 5 characters long.")
	private String title;
	
	@Column
	@NotNull
	@Size(min=5, message="Artist name must be at least 5 characters long.")
	private String artist;
	
	@Column
	@NotNull
	@Min(value=1, message="Rating must be between 1 and 10")
	@Max(value=10, message="Rating must be between 1 and 10")
	private int rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	//Constructors
	public Song(String title, String artist, int rating) {
		super();
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	
	public Song() {		
	}
	
	//created/updated at annotated
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getRating() {
		return rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
