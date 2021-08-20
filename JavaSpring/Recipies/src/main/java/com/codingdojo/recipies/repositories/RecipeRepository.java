package com.codingdojo.recipies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.recipies.models.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	Recipe findByUser(Long userId);
	
	List<Recipe> findAll();
	
	@Query(value="SELECT recipes.content, users.name,  COUNT(users_liked_recipes.user_id) AS likes FROM recipes join users_liked_recipes on recipes.id = users_liked_recipes.recipe_id join users on users_liked_recipes.user_id = users.id group by recipe_id;", nativeQuery=true)
    List<Object[]> joinUsersAndRecipes();
}
