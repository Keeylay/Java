package com.codingdojo.greatideas.controllers;

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

import com.codingdojo.greatideas.models.GreatIdea;
import com.codingdojo.greatideas.models.User;
import com.codingdojo.greatideas.services.GreatIdeaService;
import com.codingdojo.greatideas.services.UserService;

@Controller
public class GreatIdeaController {
	@Autowired
    private UserService userServ;
	
	@Autowired
	private GreatIdeaService greatIdeaServ;
	
	public GreatIdeaController(UserService userServ, GreatIdeaService greatIdeaServ) {
        this.userServ = userServ;
        this.greatIdeaServ = greatIdeaServ;
    }
	
	@GetMapping("/greatIdeas/new")
    public String newGreatIdea(@ModelAttribute("newGreatIdea") GreatIdea newGreatIdea, 
    		Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	User user = userServ.findUser(loggedInUserID);
    	model.addAttribute("user", user);
    		return "newGreatIdea.jsp";    		
    }
    
    @PostMapping("/greatIdeas/new")
    public String creatGreatIdea(@Valid @ModelAttribute("newGreatIdea") BindingResult result, 
    		GreatIdea newGreatIdea, HttpSession session) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(result.hasErrors()) {
    		return "newGreatIdea.jsp";
    	}
    	User user = userServ.findUser(loggedInUserID);
    	newGreatIdea.setUser(user);	
    	greatIdeaServ.create(newGreatIdea);
    	
    	return "redirect:/greatIdeas";
    }
    
    @GetMapping("/greatIdeas")
    public String greatIdeas(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	List<GreatIdea> greatIdeas = greatIdeaServ.getAll();
    	model.addAttribute("greatIdeas", greatIdeas);

    	// get logged in user object to pass whole object into template
    	
    	User loggedIn = this.userServ.findUser(loggedInUserID);
    	model.addAttribute("loggedIn", loggedIn);
    	
    	
    	return "greatIdeas.jsp";
    }
    
    @GetMapping("/greatIdeas/{id}")
    public String showGreatIdea(@PathVariable("id") Long id, Model model, 
    		HttpSession session, RedirectAttributes redirectAttributes) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	GreatIdea greatIdea = greatIdeaServ.findGreatIdea(id);
    	model.addAttribute("greatIdea", greatIdea);
    	return "showGreatIdea.jsp";
    }
    
    @GetMapping("/greatIdeas/{id}/edit")
    public String editGreatIdea(@PathVariable("id") Long id, Model model, 
    		HttpSession session, RedirectAttributes redirectAttributes) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}

    	GreatIdea greatIdea = greatIdeaServ.findGreatIdea(id);
    	User user = userServ.findUser(loggedInUserID);
    	
    	if (user.getId() == greatIdea.getUser().getId()) {
    		model.addAttribute("greatIdea", greatIdea);
    		return "editGreatIdea.jsp";
    	} else {
    		redirectAttributes.addFlashAttribute("notAllowed", "You cannot edit another user's greatIdea");
    		return "redirect:/greatIdeas";
    	}
    }
    
    @PostMapping("/greatIdeas/{id}/edit")
    public String saveEdit(@Valid @ModelAttribute("greatIdea") GreatIdea greatIdea, 
    		BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	if(result.hasErrors()) {
    		return "editGreatIdea.jsp";
    	}
    	User user = userServ.findUser(loggedInUserID);
    	greatIdea.setUser(user);
    	greatIdeaServ.create(greatIdea);
    	return "redirect:/greatIdeas";
    }
    
    @GetMapping("/greatIdeas/{id}/delete")
    public String deleteGreatIdea(@PathVariable("id") Long id, Model model, 
    		HttpSession session, RedirectAttributes redirectAttributes) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}   	
    	
    	GreatIdea greatIdea = greatIdeaServ.findGreatIdea(id);
    	User user = userServ.findUser(loggedInUserID);
    	if (user.getId() == greatIdea.getUser().getId()) {
    		greatIdeaServ.deleteGreatIdea(greatIdea);
    		return "redirect:/greatIdeas";
    	} else {
    		redirectAttributes.addFlashAttribute("notAllowed", "You cannot remove another user's greatIdea");
    		return "redirect:/greatIdeas";
    	}
    }
    
    @GetMapping("/greatIdeas/{id}/like")
    public String likeGreatIdea(@PathVariable("id") Long id, 
    		RedirectAttributes redirectAttributes, HttpSession session) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	User user = userServ.findUser(loggedInUserID);
    	GreatIdea greatIdea = greatIdeaServ.findGreatIdea(id);
    	List<User> usersLiked = greatIdea.getUsersLiked();
    	if(usersLiked.contains(user)) {
    		return "redirect:/greatIdeas";
    	}
    	usersLiked.add(user);
    	greatIdea.setUsersLiked(usersLiked);
    	greatIdeaServ.create(greatIdea);
    	return "redirect:/greatIdeas";
    }
}
