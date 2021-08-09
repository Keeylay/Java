package com.codingdojo.javaspring.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class HelloHumanApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	// Annotation
	@RequestMapping("/")
	// Method that map request
	public String hello() {
		return "Hello Human";
	}
//	@RequestMapping()
//	public String welcome() {
//		return "welcome to Spring Boot!";
//	}
	
	@RequestMapping("/{name}")
	public String name(@PathVariable("name") String name) {
		return "Hello " + name;
	}
	

}
