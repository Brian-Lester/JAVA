package com.brianLester.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brianLester.SaveTravels.models.Expense;
import com.brianLester.SaveTravels.repo.ExpenseRepo;
import com.brianLester.burgerTracker.models.burgers;



@Service
public class ExpenseService {
	private final ExpenseRepo expenseRepo;
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo=expenseRepo;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	public Expense createOrUpdateExpense(Expense e) {
		return expenseRepo.save(e);
	}
	 public Expense findById(Long id) {
	    	return expenseRepo.findByid(id);
	    }
	 
	 public void deleteById(Long id) {
		 expenseRepo.deleteById(id);
	 }

}
