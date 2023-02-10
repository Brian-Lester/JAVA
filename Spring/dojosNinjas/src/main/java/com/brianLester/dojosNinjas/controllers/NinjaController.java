package com.brianLester.dojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brianLester.dojosNinjas.models.Ninja;
import com.brianLester.dojosNinjas.services.DojoService;
import com.brianLester.dojosNinjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	
	@GetMapping("/ninja/create")
	public String rNinjaCreate(Model model, @ModelAttribute("ninja")Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		 System.out.println(model.addAttribute("dojos", dojoService.allDojos()));
	
		return "createNinja.jsp";
		
	}
	
	@PostMapping("/ninja/create")
	public String pNinjaCreate(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "createNinja.jsp";
		}
		else {
			ninjaService.createOrUpdateNinja(ninja);
			return "redirect:/";

		}
	}
}
