package com.codingdojo.javaspring.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		System.out.println("testing to see if working");
		return "index.jsp";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "results.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="name") String name, 
			@RequestParam(value="Location_chosen") String Location_chosen, 
			@RequestParam(value="favorite_language") String favorite_language, 
			@RequestParam(value="comment") String comment, 
			HttpSession session) {
		
		session.setAttribute("name", name);
		session.setAttribute("Location_chosen", Location_chosen);
		session.setAttribute("favorite_language", favorite_language);
		session.setAttribute("comment", comment);
		
		return "redirect:/success";
	}
}
