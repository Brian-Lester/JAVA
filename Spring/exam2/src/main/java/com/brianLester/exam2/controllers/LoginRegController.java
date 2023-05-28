package com.brianLester.exam2.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brianLester.exam2.models.LoginUser;
import com.brianLester.exam2.models.User;
import com.brianLester.exam2.services.HouseService;
import com.brianLester.exam2.services.UserService;

@Controller
public class LoginRegController {
	
    // Add once service is implemented:
     @Autowired
     UserService userServ;
     
     @Autowired
     HouseService houseServ;
     

	
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    
        session.invalidate();
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "LoginReg.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        User u =  userServ.register(newUser, result);
        if(u == null) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "LoginReg.jsp";
        }
        
        
//        userServ.createOrUpdateUser(u);
        session.setAttribute("user",userServ.createOrUpdateUser(u));
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         Optional<User> user = userServ.login(newLogin, result);
         
    
        if(user == null) {
            model.addAttribute("newUser", new User());
            return "LoginReg.jsp";
        }
        
        
         
        session.setAttribute("user", user.get());
    
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String dashboard(HttpSession session, Model model){
    	if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
    	else {
    	
    	User u =  (User) session.getAttribute("user");
    	
    	model.addAttribute("houses", houseServ.allHouses());
    	
    	model.addAttribute("user", u);
    
    	
    	return "dash.jsp";
    	}
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

}
