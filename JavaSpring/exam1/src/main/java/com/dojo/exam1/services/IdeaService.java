package com.dojo.exam1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.dojo.exam1.models.Idea;
import com.dojo.exam1.models.User;
import com.dojo.exam1.repositories.IdeaRepository;

@Service
public class IdeaService {
	private final IdeaRepository ideaRepo;
	
	public IdeaService(IdeaRepository ideaRepo) {
		this.ideaRepo = ideaRepo;
	}
	
	public Idea create(Idea idea) {
		return ideaRepo.save(idea);
	}
	
	public List<Idea> getAll() {
		return (List<Idea>) ideaRepo.findAll();
	}
	
	public Idea findIdea(Long id) {
		Optional<Idea> optionalIdea = ideaRepo.findById(id);
		if(optionalIdea.isPresent()) {
			return optionalIdea.get();
		} else {
			return null;
		}
	}
	
	public void deleteIdea(Idea idea) {
		ideaRepo.delete(idea);
	}
	
	
}
