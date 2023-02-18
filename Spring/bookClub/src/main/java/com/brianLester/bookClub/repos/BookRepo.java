package com.brianLester.bookClub.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.bookClub.models.Book;

public interface BookRepo extends CrudRepository<Book, Long>{

	List<Book> findAll();
}
