package com.codingdojo.nrampton.countries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String country_code;
	private String district;
	private Long population;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getDistrict() {
		return district;
	}

	public Long getPopulation() {
		return population;
	}

	public Country getCountry() {
		return country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
