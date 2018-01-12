package com.codingdojo.nrampton.languages.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language {
	@NotNull
	@Size(min=2, max=20)
	private String name;
	
	@NotNull
	@Size(min=2, max=20)
	private String creator;
	
	@NotNull
	private String version;
	
	
	//constructors
	public Language() {		
	}
	
	public Language(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	
	//getters and setters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
