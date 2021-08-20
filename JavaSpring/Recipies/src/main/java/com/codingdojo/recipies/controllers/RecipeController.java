package com.codingdojo.recipies.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.recipies.models.Recipe;
import com.codingdojo.recipies.models.User;
import com.codingdojo.recipies.services.RecipeService;
import com.codingdojo.recipies.services.UserService;

@Controller
public class RecipeController {
	@Autowired
    private UserService userServ;
	
	@Autowired
	private RecipeService recipeServ;
	
	public RecipeController(UserService userServ, RecipeService recipeServ) {
        this.userServ = userServ;
        this.recipeServ = recipeServ;
    }
	
	@GetMapping("/recipes/new")
    public String newRecipe(HttpSession session, Model model, RedirectAttributes redirectAttributes, @ModelAttribute("newRecipe") Recipe newRecipe) {
    	if (session.getAttribute("user_id") != null) {
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    		model.addAttribute("user", user);
    		return "newRecipe.jsp";    		
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You must log in first");
    		return "redirect:/";
    	}
    }
    
    @PostMapping("/recipes/new")
    public String creatRecipe(@Valid @ModelAttribute("newRecipe") Recipe newRecipe, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "newRecipe.jsp";
    	}
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	newRecipe.setUser(user);
    	recipeServ.create(newRecipe);
    	
    	return "redirect:/recipes";
    }
    
    @GetMapping("/recipes")
    public String recipes(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	List<Recipe> recipes = recipeServ.getAll();
    	model.addAttribute("recipes", recipes);
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	// get logged in user object to pass whole object into template
    	
    	Long user_id = (Long) session.getAttribute("user_id");
    	User loggedIn = this.userServ.findUser(user_id);
    	model.addAttribute("loggedIn", loggedIn);
    	
    	
    	return "recipes.jsp";
    }
    
    @GetMapping("/recipes/{id}")
    public String showRecipe(@PathVariable("id") Long id, Model model) {
    	Recipe recipe = recipeServ.findRecipe(id);
    	model.addAttribute("recipe", recipe);
    	return "showRecipe.jsp";
    }
    
    @GetMapping("/recipes/{id}/edit")
    public String editRecipe(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	Recipe recipe = recipeServ.findRecipe(id);
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	if (user.getId() == recipe.getUser().getId()) {
    		model.addAttribute("recipe", recipe);
    		return "editRecipe.jsp";
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You cannot edit another user's recipe");
    		return "redirect:/recipes";
    	}
    }
    
    @PostMapping("/recipes/{id}/edit")
    public String saveEdit(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "editRecipe.jsp";
    	}
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	recipe.setUser(user);
    	recipeServ.create(recipe);
    	return "redirect:/recipes";
    }
    
    @GetMapping("/recipes/{id}/delete")
    public String deleteRecipe(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	Recipe recipe = recipeServ.findRecipe(id);
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	if (user.getId() == recipe.getUser().getId()) {
    		recipeServ.deleteRecipe(recipe);
    		return "redirect:/recipes";
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You cannot edit another user's recipe");
    		return "redirect:/recipes";
    	}
    }
    
    @GetMapping("/recipes/{id}/like")
    public String likeRecipe(@PathVariable("id") Long id, HttpSession session, RedirectAttributes redirectAttributes) {
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	Recipe recipe = recipeServ.findRecipe(id);
    	List<User> usersLiked = recipe.getUsersLiked();
    	if(usersLiked.contains(user)) {
    		redirectAttributes.addFlashAttribute("error", "already liked");
    		return "redirect:/recipes";
    	}
    	usersLiked.add(user);
    	recipe.setUsersLiked(usersLiked);
    	recipeServ.create(recipe);
    	redirectAttributes.addFlashAttribute("error", "Liked! Thank you!");
    	return "redirect:/recipes";
    }
}
