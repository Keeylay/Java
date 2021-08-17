package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageServices {
	private final LanguageRepository languageRepository;
		
	public LanguageServices(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;		
	}
	
	// return all languages
	public List<Languages> allLanguages() {
		return this.languageRepository.findAll();
	}
	
	// create language
	public Languages createLanguage(Languages langurage) {
		return this.languageRepository.save(langurage);
	}
	
	// find one language
	public Languages oneLanguage(Long id) {
		return this.languageRepository.findById(id).orElse(null);
	}
	
	// update language
	public Languages updateLanguage(Languages language) {
		return this.languageRepository.save(language);
	}
	
	// delete language
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
	}
	
	
}
