package com.codingdojo.nrampton.languages.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.languages.models.Language;
import com.codingdojo.nrampton.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository lRepo) {
		this.languageRepository = lRepo;
	}
	
	public List<Language> getAllLanguages() {
		return (ArrayList<Language>) languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public Language findLanguageById(Long id) {
		return languageRepository.findOne(id);	
	}
		
	public void destroyLanguage(Long id) {
		languageRepository.delete(id);
	}
	
	public void updateLanguage(Language lang) {
		System.out.println("ID we're going to update: " + lang.getId());
		System.out.println("And here's its name: " + lang.getName());
		languageRepository.save(lang);
	}
}
