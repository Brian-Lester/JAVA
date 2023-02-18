package com.brianLester.bookClub.controllers;

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

import com.brianLester.bookClub.models.Book;
import com.brianLester.bookClub.services.BookService;
import com.brianLester.bookClub.services.UserService;

@Controller
public class BookController {

	@Autowired
	BookService bookServ;
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/rBookForm")
	public String rBookForm(@ModelAttribute("book")Book book, Model model, HttpSession session) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		
		
		model.addAttribute("user", session.getAttribute("user") );
		
		return "BookForm.jsp";
	}
	
	@PostMapping("/book/create/")
	public String pBookForm(@Valid @ModelAttribute("book")Book book, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		
		
		if(result.hasErrors()) {
			return "BookForm.jsp";
		}
		else {
			bookServ.createOrUpdateUser(book);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/view/book/{id}")
	public String viewBook(HttpSession session, Model model ,@PathVariable("id")Long id) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		Optional<Book> book = bookServ.findById(id);
		model.addAttribute("book",book.get());
		return "ViewBook.jsp";

	}
	
	@GetMapping("delete/{book_id}/{user_id}")
	public String deleteBook(HttpSession session,@PathVariable("book_id")Long book_id, @PathVariable("user_id")Long user_id) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		Optional<Book> book = bookServ.findById(book_id);
		
		if (user_id != book.get().getUser().getId()) {
			return "redirect:/home";
		}
		else {
			bookServ.deleteById(book_id);
			return "redirect:/home";
		}
	}
	
	@GetMapping("edit/{book_id}/{user_id}")
	public String reditBook(HttpSession session,@PathVariable("book_id")Long book_id, @PathVariable("user_id")Long user_id, Model model) {
		if(session.getAttribute("user")== null) {
    		return "redirect:/";
    	}
		Optional<Book> book = bookServ.findById(book_id);
		
		if (user_id != book.get().getUser().getId()) {
			return "redirect:/home";
		}
		else {
			
			model.addAttribute("book", book.get());
			return "editBook.jsp";
			
		}
	}
	
	@PostMapping("edit/book/{id}")
	public String updateBook(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		
		
		if(result.hasErrors()) {
			return "BookForm.jsp";
		}
		else {
			bookServ.createOrUpdateUser(book);
			return "redirect:/home";
		}
	}
		
}

