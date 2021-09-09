package com.codingdojo.recipies.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.recipies.models.LoginUser;
import com.codingdojo.recipies.models.User;
import com.codingdojo.recipies.services.UserService;

@Controller
public class HomeController {

	@Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        User Temp= new User();
        Temp.getFirstName();
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/recipes";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
    	Long loggedInUserID = (Long)session.getAttribute("user_id");
    	
    	if(loggedInUserID == null) {
    		redirectAttributes.addFlashAttribute("notAllowed", "must be logged in to view this page" );
    		return "redirect:/";
    	}
    	
    	User loggedInUser = this.userServ.findUser(loggedInUserID);
    	
    	model.addAttribute("loggedInUser", loggedInUser);
    	
    	return "home.jsp";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        
        session.setAttribute("user_id", user.getId());
        return "redirect:/recipes";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	
    	return "redirect:/";
    }
}
