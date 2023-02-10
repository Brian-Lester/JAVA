package com.brianLester.dojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brianLester.dojosNinjas.models.Dojo;
import com.brianLester.dojosNinjas.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	DojoService service;
	
	@GetMapping("/")
	public String indec() {
		return "index.jsp";
	}
	
	@GetMapping("/dojo/create")
	public String rDojoForm(@ModelAttribute("dojo")Dojo dojo) {
	return "createDojo.jsp";
	}

	
	@PostMapping("/dojo/create")
	public String pDojoForm(@Valid @ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		}
		else {
			service.createOrUpdateDojo(dojo);
			return "redirect:/";
	}
	}	
	
	@GetMapping("/dojo/all")
	public String allDojos(Model model) {
		model.addAttribute("dojos", service.allDojos());
		return "dojoAll.jsp";
	}
}

