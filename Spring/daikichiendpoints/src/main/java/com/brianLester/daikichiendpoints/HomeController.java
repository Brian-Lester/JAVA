package com.brianLester.daikichiendpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/daikichi")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today youll find luck in all your endevors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Big things are waiting for you!";
	}

}
