package com.codingdojo.greatideas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.greatideas.models.GreatIdea;
import com.codingdojo.greatideas.repositories.GreatIdeaRepository;

@Service
public class GreatIdeaService {
	private final GreatIdeaRepository greatIdeaRepo;
	
	public GreatIdeaService(GreatIdeaRepository greatIdeaRepo) {
		this.greatIdeaRepo = greatIdeaRepo;
	}
	
	public GreatIdea create(GreatIdea greatIdea) {
		return greatIdeaRepo.save(greatIdea);
	}
	
	public List<GreatIdea> getAll() {
		return (List<GreatIdea>) greatIdeaRepo.findAll();
	}
	
	public GreatIdea findGreatIdea(Long id) {
		Optional<GreatIdea> optionalGreatIdea = greatIdeaRepo.findById(id);
		if(optionalGreatIdea.isPresent()) {
			return optionalGreatIdea.get();
		} else {
			return null;
		}
	}
	
	public void deleteGreatIdea(GreatIdea greatIdea) {
		greatIdeaRepo.delete(greatIdea);
	}
}
