package com.brianLester.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brianLester.dojosNinjas.models.Ninja;
import com.brianLester.dojosNinjas.repos.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepo ninjaRepo; 
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja createOrUpdateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	 public Optional<Ninja> findById(Long id) {
	    	return ninjaRepo.findById(id);
	    }
	 
	 public void deleteById(Long id) {
		 ninjaRepo.deleteById(id);
	 }
}
