package com.brianLester.burgerTracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brianLester.burgerTracker.models.burgers;
import com.brianLester.burgerTracker.repos.BurgerRepo;
import com.brianLester.burgerTracker.models.burgers;

@Service
public class BurgerService {
	
	private final BurgerRepo burgerRepo;
    
    public BurgerService(BurgerRepo burgerRepo) {
        this.burgerRepo = burgerRepo;
    }
    
    public List<burgers> allBurgers(){
    	return burgerRepo.findAll();
    }
    
    public burgers createOrUpdateBook(burgers b) {
        return burgerRepo.save(b);

}
}
