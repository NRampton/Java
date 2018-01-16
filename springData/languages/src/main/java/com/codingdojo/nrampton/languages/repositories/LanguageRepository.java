package com.codingdojo.nrampton.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nrampton.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
}
