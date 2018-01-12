package com.codingdojo.nrampton.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.languages.models.Language;

@Service
public class LanguageService {
	private List<Language> languages = new ArrayList<Language>(Arrays.asList(
			new Language("Python", "Guido van Rossum", "3.6.4"),
			new Language("Java", "James Gosling", "1.8")
			));
	
	public List<Language> getAllLanguages() {
		return languages;
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public Language getLanguageById(int id) {
		if (id < languages.size()) {
			return languages.get(id);
		}
		return null;		
	}
		
	public void destroyLanguage(int id) {
		if (id < languages.size()) {
			languages.remove(id);
		}
	}
	
	public void updateLanguage(int id, Language language) {
		if (id < languages.size()) {
			System.out.println(language);
			languages.set(id, language);
		}
	}
}
