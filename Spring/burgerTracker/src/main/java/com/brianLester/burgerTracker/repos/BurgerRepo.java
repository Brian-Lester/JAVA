package com.brianLester.burgerTracker.repos;

import org.springframework.data.repository.CrudRepository;



import com.brianLester.burgerTracker.models.burgers;

import java.util.List;

public interface BurgerRepo extends CrudRepository<burgers, Long>{
	   // this method retrieves all the books from the database
    List<burgers> findAll();
    // this method finds books with descriptions containing the search string
    List<burgers> findByburgerNameContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByburgerNameContaining(String search);
    
    burgers findByid(Long id);
}
