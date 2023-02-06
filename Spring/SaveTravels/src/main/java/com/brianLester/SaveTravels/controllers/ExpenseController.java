package com.brianLester.SaveTravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brianLester.SaveTravels.models.Expense;
import com.brianLester.SaveTravels.services.ExpenseService;


@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService =expenseService;
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expense")Expense expense) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "index.jsp";
	}
	
	@PostMapping("/create/expense")
	public String createExpense(@Valid @ModelAttribute("expense")Expense expense,BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}
		else {
			expenseService.createOrUpdateExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/{id}")
	public String edit(@PathVariable("id") Long id,Model model, @ModelAttribute("expense")Expense expense) {
		model.addAttribute("expense", expenseService.findById(id));
		return "Edit.jsp";
	}
	
	@PutMapping("/edit/expense/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		 if (result.hasErrors()) {
	            return "Edit.jsp";
	        } else {
	            expenseService.createOrUpdateExpense(expense);
	            return "redirect:/";
	        }
	    }
	
	@DeleteMapping("expense/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/view/expense/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findById(id);
		model.addAttribute("expense",expense);
		return "view.jsp";
	}
}


