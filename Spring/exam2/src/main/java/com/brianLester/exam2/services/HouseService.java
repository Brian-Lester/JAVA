package com.brianLester.exam2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brianLester.exam2.models.House;
import com.brianLester.exam2.repos.HouseRepo;

@Service
public class HouseService {
	
	@Autowired
	HouseRepo repo;
	
	public List<House> allHouses(){
		return repo.findAll();
	}

	
	public House create(House newHouse, BindingResult result) {
	      
	      if (result.hasErrors()) {
	    	  return null;
	      }
	      Date date = new Date();
	      newHouse.setListingDate(date);
	      
	      return repo.save(newHouse);
	      
	 }
	
	public Optional<House> findById(Long id) {
		
		
    	return repo.findById(id);
    }
	
	public void deleteById(Long id) {
		 repo.deleteById(id);
	 }
	
	public House update(House newHouse, BindingResult result) {
	      Date date = new Date();
	      
	      if (result.hasErrors()) {
	    	  return null;
	      }
//	      String test =newHouse.getListingDate().toString();
//	      if(!test.matches("^\d{4}-\d{2}-\d{2}")) {
//	    	  result.rejectValue("listingDate", "listingDate", "date must yyyy-mm-dd format");
//	    	  return null;
//	      }
	      if(newHouse.getListingDate().compareTo(date) > 0) {
	    	  result.rejectValue("listingDate", "listingDate", "date cannot be in the future");
	    	  return null;
	      }
	      
	      
	      return repo.save(newHouse);
	      
	 }
}
