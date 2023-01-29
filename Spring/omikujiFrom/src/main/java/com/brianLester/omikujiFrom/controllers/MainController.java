package com.brianLester.omikujiFrom.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return"form.jsp";
	}
	
	@PostMapping("/form/post")
	public String post(@RequestParam(value="num") Integer num,
						@RequestParam(value="city") String city,
						@RequestParam(value="person")String person,
						@RequestParam(value="hobby")String hobby,
						@RequestParam(value="thing")String thing,
						@RequestParam(value="nice")String nice,
						HttpSession session) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		
		
		
		return "redirect:/show/story";
		
	}
	
	@GetMapping("/show/story")
	public String show() {
		return"story.jsp";
		
	}
}
