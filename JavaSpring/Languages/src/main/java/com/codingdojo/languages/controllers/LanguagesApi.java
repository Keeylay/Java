package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.services.LanguageServices;

@RestController
public class LanguagesApi {
	private final LanguageServices langaugeServices;
	
	public LanguagesApi(LanguageServices langaugeServices) {
		this.langaugeServices = langaugeServices;
	}
	
	@RequestMapping("/api/languages")
	public List<Languages> allLanguages() {
		return this.langaugeServices.allLanguages();
	}
	
	@PostMapping("/api/languages")
	public Languages createLanguage(@RequestParam(value = "name") String name,
			@RequestParam(value = "creator") String creator,
			@RequestParam(value = "version") Integer version) {
		Languages language = new Languages(name, creator, version);
		
		return this.langaugeServices.createLanguage(language);
	}
	
	@PutMapping("/api/language/update/{id}")
	public Languages updateBook(@PathVariable("id") Long id, 
			@RequestParam(value = "name") String name,
			@RequestParam(value = "creator") String creator,
			@RequestParam(value = "version") Integer version) {
		
		Languages language = this.langaugeServices.oneLanguage(id);
		
		language.setName(name);
		language.setCreator(creator);
		language.setVersion(version);
		
		return this.langaugeServices.updateLanguage(language);
	}
	
	@DeleteMapping("/api/langauge/delete/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		this.langaugeServices.deleteLanguage(id);
	}
}
