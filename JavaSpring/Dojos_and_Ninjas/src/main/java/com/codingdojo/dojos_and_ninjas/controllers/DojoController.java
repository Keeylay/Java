package com.codingdojo.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos_and_ninjas.models.Dojo;
import com.codingdojo.dojos_and_ninjas.models.Ninja;
import com.codingdojo.dojos_and_ninjas.services.AppService;

@Controller
public class DojoController {
	private final AppService appService;
	
	public DojoController(AppService appService) {
		this.appService = appService;
	}
	
	@GetMapping("/")
	public String welcomeToDojo(Model model, @ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> allDojos = this.appService.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "index.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		System.out.println(dojo);
		System.out.println(dojo.getName());
		
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "index.jsp";
		}
		else {
			this.appService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/ninja")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Ninja> allNinjas = this.appService.findAllNinjas();
		model.addAttribute("allNinjas", allNinjas);
		
		List<Dojo> allDojos = this.appService.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "create.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		System.out.println(ninja);
		System.out.println(ninja.getDojo().getName());
		
		if(result.hasErrors()) {
			List<Ninja> allNinjas = this.appService.findAllNinjas();
			model.addAttribute("allNinjas", allNinjas);
			
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "create.jsp";
		}
		else {
			this.appService.createNinja(ninja);
			return "redirect:/ninja";
		}
	}
	
	
	@GetMapping("/dojo/{id}")
	public String showDojoInfo(@PathVariable("id") Long id, Model model) {
		
		Dojo dojo = this.appService.getOneDojo(id);
		model.addAttribute(dojo);
		
	
		return "show.jsp";
	}
}
