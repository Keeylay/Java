package com.dojo.exam1;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.exam1.models.Idea;
import com.dojo.exam1.models.User;
import com.dojo.exam1.services.IdeaService;
import com.dojo.exam1.services.UserService;
import com.dojo.exam1.validators.UserValidator;

@Controller
public class IdeasController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final IdeaService ideaService;
    
    public IdeasController(UserService userService, UserValidator userValidator, IdeaService ideaService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.ideaService = ideaService;
    }
    
    @GetMapping("/ideas/new")
    public String newIdea(HttpSession session, Model model, RedirectAttributes redirectAttributes, @ModelAttribute("newIdea") Idea newIdea) {
    	if (session.getAttribute("userId") != null) {
    		User user = userService.findUserById((Long)session.getAttribute("userId"));
    		model.addAttribute("user", user);
    		return "newIdea.jsp";    		
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You must log in first");
    		return "redirect:/";
    	}
    }
    
    @PostMapping("/ideas/new")
    public String creatIdea(@Valid @ModelAttribute("newIdea") Idea newIdea, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "redirect:/ideas/new";
    	}
    	User user = userService.findUserById((Long) session.getAttribute("userId"));
    	newIdea.setUser(user);
    	ideaService.create(newIdea);
    	
    	return "redirect:/ideas";
    }
    
    @GetMapping("/ideas")
    public String ideas(Model model, HttpSession session) {
    	List<Idea> ideas = ideaService.getAll();
    	model.addAttribute("ideas", ideas);
    	model.addAttribute("name", session.getAttribute("name"));
    	return "ideas.jsp";
    }
    
    @GetMapping("/ideas/{id}")
    public String showIdea(@PathVariable("id") Long id, Model model) {
    	Idea idea = ideaService.findIdea(id);
    	model.addAttribute("idea", idea);
    	return "showIdea.jsp";
    }
    
    @GetMapping("/ideas/{id}/edit")
    public String editIdea(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	Idea idea = ideaService.findIdea(id);
    	User user = userService.findUserById((Long) session.getAttribute("userId"));
    	if (user.getId() == idea.getUser().getId()) {
    		model.addAttribute("idea", idea);
    		return "editIdea.jsp";
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You cannot edit another user's idea");
    		return "redirect:/ideas";
    	}
    }
    
    @PostMapping("/ideas/{id}/edit")
    public String saveEdit(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "redirect:/ideas/{id}/edit";
    	}
    	User user = userService.findUserById((Long) session.getAttribute("userId"));
    	idea.setUser(user);
    	ideaService.create(idea);
    	return "redirect:/ideas";
    }
    
    @GetMapping("/ideas/{id}/delete")
    public String deleteIdea(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	Idea idea = ideaService.findIdea(id);
    	User user = userService.findUserById((Long) session.getAttribute("userId"));
    	if (user.getId() == idea.getUser().getId()) {
    		ideaService.deleteIdea(idea);
    		return "redirect:/ideas";
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You cannot edit another user's idea");
    		return "redirect:/ideas";
    	}
    }
    
    @GetMapping("/ideas/{id}/like")
    public String likeIdea(@PathVariable("id") Long id, HttpSession session, RedirectAttributes redirectAttributes) {
    	User user = userService.findUserById((Long) session.getAttribute("userId"));
    	Idea idea = ideaService.findIdea(id);
    	List<User> usersLiked = idea.getUsersLiked();
    	if(usersLiked.contains(user)) {
    		redirectAttributes.addFlashAttribute("error", "already liked");
    		return "redirect:/ideas";
    	}
    	usersLiked.add(user);
    	idea.setUsersLiked(usersLiked);
    	ideaService.create(idea);
    	redirectAttributes.addFlashAttribute("error", "Liked! Thank you!");
    	return "redirect:/ideas";
    }
    
}
