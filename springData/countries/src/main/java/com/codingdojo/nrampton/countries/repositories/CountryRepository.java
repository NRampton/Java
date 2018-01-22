package com.codingdojo.nrampton.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	@Query(value="SELECT countries.name, languages.language, languages.percentage FROM countries JOIN languages ON countries.id = languages.country_id WHERE language = ?1 ORDER BY languages.percentage DESC", nativeQuery=true)
	List<Object> findCountriesByLanguage(String language);
	
	@Query(value="SELECT countries.name, COUNT(cities.id) FROM countries JOIN cities ON countries.id = cities.country_id GROUP BY countries.name ORDER BY COUNT(cities.id) DESC", nativeQuery=true)
	List<Object> findCitiesInCountries();
}
