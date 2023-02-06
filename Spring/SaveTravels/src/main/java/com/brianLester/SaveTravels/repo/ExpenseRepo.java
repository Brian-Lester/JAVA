package com.brianLester.SaveTravels.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.SaveTravels.models.Expense;

public interface ExpenseRepo extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
	
	Expense findByid(Long id);
}
