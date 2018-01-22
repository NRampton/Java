package com.codingdojo.nrampton.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
