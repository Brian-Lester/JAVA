package com.brianLester.burgerTracker.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.brianLester.burgerTracker.models.burgers;
import com.brianLester.burgerTracker.services.BurgerService;

@Controller
public class BurgerController {
	 private final BurgerService burgerService;
	 public BurgerController(BurgerService burgerService){
	     this.burgerService = burgerService;
	 }
	
	
	@GetMapping("/all")
	public String index(Model model,@ModelAttribute("burger") burgers burger) {
		model.addAttribute("burgers", burgerService.allBurgers());
		return "Main.jsp";
	}
	
	@PostMapping("/")
	public String createBurger(@Valid @ModelAttribute("burger") burgers burger, BindingResult result) {
		if(result.hasErrors()) {
			return "Main.jsp";
		}
		else {
			burgerService.createOrUpdateBook(burger);
			return"redirect:/all";
		}
	}
	
	@GetMapping("burger/{id}")
	public String editBurger(@PathVariable("id")Long id, Model model) {
		burgers burger = burgerService.findById(id);
		model.addAttribute("burger", burger);
		return"Edit.jsp";
	
	}
	
	@PostMapping("/burger/{id}")
	public String update(@Valid @ModelAttribute ("burger") burgers burger, BindingResult result){
        if (result.hasErrors()) {
            return "Edit.jsp";
        } else {
            burgerService.createOrUpdateBook(burger);
            return "redirect:/all";
        }
	}

}
