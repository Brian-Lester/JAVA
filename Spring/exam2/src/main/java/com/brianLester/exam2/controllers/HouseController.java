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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brianLester.exam2.models.House;
import com.brianLester.exam2.models.Messages;
import com.brianLester.exam2.models.User;
import com.brianLester.exam2.services.HouseService;
import com.brianLester.exam2.services.MessageService;
import com.brianLester.exam2.services.UserService;

@Controller
public class HouseController {
	
	@Autowired
	HouseService houseServ;
	
	@Autowired
	MessageService mServ;
	
	@Autowired
	UserService uServ;
	
	
	@GetMapping("/rHouseForm")
	public String rBookForm(@ModelAttribute("house")House house, Model model, HttpSession session) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		
		
		model.addAttribute("user", session.getAttribute("user") );
		
		return "HouseForm.jsp";
	}
	
	@PostMapping("/house/create/")
	public String pShowForm(@Valid @ModelAttribute("house") House house, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		
		House h =houseServ.create(house, result);
		
		 if(h == null) {
	            return "HouseForm.jsp";
	        }
		else {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/view/house/{id}")
	public String viewBook(HttpSession session, Model model ,@PathVariable("id")Long id, @ModelAttribute("newMessage") Messages newMessage) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		Optional<House> house = houseServ.findById(id);
		model.addAttribute("house",house.get());
		
		
		return "ViewHouse.jsp";

	}
	
	@PostMapping("/add/message/")
	public String addMessage(@Valid @ModelAttribute("newMessage")Messages newMessage,BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		
		
		Messages m = mServ.create(newMessage, result);
		
		if (m==null) {
			Optional<House> house = houseServ.findById(newMessage.getHouse().getId());
			model.addAttribute("house",house.get());
			return "ViewHouse.jsp";
	}
		else {
			return "redirect:/view/house/" + newMessage.getHouse().getId();
		}
	}
	
	@GetMapping("/delete/{house_id}/{user_id}")
	public String deleteHouse(HttpSession session,@PathVariable("house_id")Long house_id, @PathVariable("user_id")Long user_id) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		 Optional<House> house = houseServ.findById(house_id);
		 User user = (User) session.getAttribute("user");
		 if(user.getId()!= house.get().getUser().getId()) {
			 
		    	return "redirect:/";
		    }
		 else {
//			 System.out.println(user.getId());
//			 System.out.println(house.get().getUser().getId());
			 houseServ.deleteById(house_id);
			 return "redirect:/home";
		 }
	}
		
	@GetMapping("/edit/{house_id}/{user_id}")
	public String editHouse(HttpSession session,@PathVariable("house_id")Long house_id, @PathVariable("user_id")Long user_id, Model model) {
		if(session.getAttribute("user")== null) {
	    	return "redirect:/";
		}
	    	
	    Optional<House> house = houseServ.findById(house_id);
	    User user = (User) session.getAttribute("user");
	    
	    if(user.getId() != house.get().getUser().getId()) {
	    	return "redirect:/";
	    }
	    else {
	    	model.addAttribute("house", house.get());
	    	return"EditHouse.jsp";
	    }
	    
		}
	
	@PostMapping("/edit/house/{id}")
	public String updateHouse(@Valid @ModelAttribute("house")House house,BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("user")== null) {
	    	return "redirect:/";
		}
	    House h = houseServ.update(house, result);
	    User user = (User) session.getAttribute("user");
	    
	    if(user.getId() != house.getUser().getId()) {
	    	return "redirect:/";
	    }
	    if(h == null){
	    	model.addAttribute("house", house);
	    	return"EditHouse.jsp";
	    }
	    return "redirect:/home";
	    	

	}
}


