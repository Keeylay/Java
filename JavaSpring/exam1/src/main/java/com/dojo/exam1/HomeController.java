package com.dojo.exam1;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.exam1.models.User;
import com.dojo.exam1.services.UserService;
import com.dojo.exam1.validators.UserValidator;

@Controller
public class HomeController {
	private final UserService userService;
	private final UserValidator userValidator;
    
    public HomeController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @GetMapping("/")
    public String index(@ModelAttribute("user") User user) {
    	return "index.jsp";
    }
    
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes, Errors errors) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	userValidator.validate(user, result);
    	if (userService.findByEmail(user.getEmail()) != null) {
    		result.rejectValue("email", null, "Email must be unique");
    	}
        if(result.hasErrors()) {
            return "index.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        session.setAttribute("name", u.getName());
        return "redirect:/ideas";
    	
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userService.authenticateUser(email, password)) {
    		session.setAttribute("userId", userService.findByEmail(email).getId());
    		session.setAttribute("name", userService.findByEmail(email).getName());
    		return "redirect:/ideas";
    	} else {
    		redirectAttributes.addFlashAttribute("error", "invalid username or password");
    		return "redirect:/";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        // get user from session, save them in the model and return the home page
    	if (session.getAttribute("userId") != null) {
    		User user = userService.findUserById((Long)session.getAttribute("userId"));
    		model.addAttribute("user", user);
    		return "homePage.jsp";    		
    	} else {
    		redirectAttributes.addFlashAttribute("error", "You must log in first");
    		return "redirect:/";
    	}
    	
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        // invalidate session
        // redirect to login page
    	if (session.getAttribute("userId") != null) {
    		session.invalidate();
    		redirectAttributes.addFlashAttribute("error", "successfully logged out");
    	} else {
    		redirectAttributes.addFlashAttribute("error", "already logged out");
    	}
    	return "redirect:/";
    }

}
