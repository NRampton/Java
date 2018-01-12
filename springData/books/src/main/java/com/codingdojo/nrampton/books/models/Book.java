package com.codingdojo.nrampton.books.models;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Size(min=3, max=40)
	private String title;

	@Size(min=5, max=200)
	private String description;

	@Size(min=3, max=40)
	private String language;

	@Min(100)
	private int numberOfPages;
	
	
	//constructors
	public Book() {		
	}
	
	public Book(String title, String desc, String lang, int num) {
		
		this.title = title;
		this.description = desc;		
		this.language = lang;		
		this.numberOfPages = num;
	}
	
	
	//getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

}
