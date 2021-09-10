package com.codingdojo.greatideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.greatideas.models.GreatIdea;

@Repository
public interface GreatIdeaRepository extends CrudRepository<GreatIdea, Long>{
	GreatIdea findByUser(Long userID);
	
	List<GreatIdea> findAll();
}
