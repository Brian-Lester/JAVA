package com.brianLester.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brianLester.bookClub.models.Book;
import com.brianLester.bookClub.repos.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	public List<Book> allBookss(){
		return bookRepo.findAll();
	}
	
	public Book createOrUpdateUser(Book b) {
		return bookRepo.save(b);
	}
	 public Optional<Book> findById(Long id) {
	    	return bookRepo.findById(id);
	    }
	 
	 public void deleteById(Long id) {
		 bookRepo.deleteById(id);
	 }

}
