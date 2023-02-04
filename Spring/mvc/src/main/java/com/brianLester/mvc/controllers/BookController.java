package com.brianLester.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brianLester.mvc.models.Book;
import com.brianLester.mvc.services.BookService;

@Controller
public class BookController {
	 private final BookService bookService;
	 public BookController(BookService bookService){
	     this.bookService = bookService;
	 }
	
	
	@GetMapping("/book/{id}")
	public String index(Model model,@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return"index.jsp";
		
	}

}
