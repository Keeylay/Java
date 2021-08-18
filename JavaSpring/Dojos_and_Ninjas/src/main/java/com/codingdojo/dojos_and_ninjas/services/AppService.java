package com.codingdojo.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos_and_ninjas.models.Dojo;
import com.codingdojo.dojos_and_ninjas.models.Ninja;
import com.codingdojo.dojos_and_ninjas.repositories.DojoRepository;
import com.codingdojo.dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class AppService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public AppService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Dojo> findAllDojos() {
		return (List<Dojo>) this.dojoRepository.findAll();
	}
	
	public List<Ninja> findAllNinjas() {
		return (List<Ninja>) this.ninjaRepository.findAll();
	}

	//Create a Dojo
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
		
	//Create a Ninja
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
	
	//Find One Dojo
	public Dojo getOneDojo(Long id) {
		return this.dojoRepository.findById(id).orElse(null);
	}
}
