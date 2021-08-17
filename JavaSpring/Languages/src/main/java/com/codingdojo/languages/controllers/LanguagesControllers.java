package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.services.LanguageServices;

@Controller
public class LanguagesControllers {
	private final LanguageServices langaugeServices;
	
	public LanguagesControllers (LanguageServices langaugeServices) {
		this.langaugeServices = langaugeServices;
	}
	
	// All Languages && Create Language
	@GetMapping("/languages")
		public String getAllLanguages(Model model, @ModelAttribute("language") Languages languages) {
		List<Languages> allLanguages = this.langaugeServices.allLanguages();
		
		model.addAttribute("allLanguages", allLanguages);
		
		return "index.jsp";
	}
	
	@PostMapping("/languages/create")
	public String createLanguage(@Valid @ModelAttribute("language") Languages language, BindingResult result) {
		System.out.println(language.getName());
		System.out.println(language.getName());
		System.out.println(language.getName());
		if (result.hasErrors()) {
			return "index.jsp";
		}
		
		this.langaugeServices.createLanguage(language);
		
	return "redirect:/languages";
	}
	
	//Show One Language
		@GetMapping("/languages/info/{id}")
		public String showLanguage(@PathVariable("id") Long id, Model model) {
		
			Languages language = this.langaugeServices.oneLanguage(id);
			model.addAttribute("language", language);
			
		return "show.jsp";
		}
		
		//Edit Language
		@GetMapping("/languages/edit/{id}")
		public String editPet(@PathVariable("id") Long id, Model model) {
		
			Languages language = this.langaugeServices.oneLanguage(id);
			model.addAttribute("language", language);
			
			return "edit.jsp";
		}

		@PostMapping("/languages/update/{id}")
			public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Languages language, BindingResult result) {
				if (result.hasErrors()) {
		            return "edit.jsp";
		        }
				
				this.langaugeServices.updateLanguage(language);
			
			return "redirect:/languages";
		}	
		
		//delete a book
		@GetMapping("/languages/delete/{id}")
			public String deleteLanguage(@PathVariable("id") Long id) {
			
				this.langaugeServices.deleteLanguage(id);
			
			return "redirect:/languages";
		}

}
