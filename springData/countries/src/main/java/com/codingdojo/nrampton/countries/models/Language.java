package com.codingdojo.nrampton.countries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Language {

	@Id
	@GeneratedValue
	private Long id;
	private String country_code;
	private String language;
	private boolean is_official;
	private double percentage;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public String getLanguage() {
		return language;
	}
	public boolean isIs_official() {
		return is_official;
	}
	public double getPercentage() {
		return percentage;
	}
	public Country getCountry() {
		return country;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setIs_official(boolean is_official) {
		this.is_official = is_official;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
