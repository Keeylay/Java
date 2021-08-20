package com.codingdojo.recipies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.recipies.models.Recipe;
import com.codingdojo.recipies.repositories.RecipeRepository;

@Service
public class RecipeService {
	private final RecipeRepository recipeRepo;
	
	public RecipeService(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}
	
	public Recipe create(Recipe recipe) {
		return recipeRepo.save(recipe);
	}
	
	public List<Recipe> getAll() {
		return (List<Recipe>) recipeRepo.findAll();
	}
	
	public Recipe findRecipe(Long id) {
		Optional<Recipe> optionalRecipe = recipeRepo.findById(id);
		if(optionalRecipe.isPresent()) {
			return optionalRecipe.get();
		} else {
			return null;
		}
	}
	
	public void deleteRecipe(Recipe recipe) {
		recipeRepo.delete(recipe);
	}
}
