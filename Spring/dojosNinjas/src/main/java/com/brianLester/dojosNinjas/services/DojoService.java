package com.brianLester.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brianLester.dojosNinjas.models.Dojo;
import com.brianLester.dojosNinjas.repos.DojoRepo;

@Service
public class DojoService {

	@Autowired
	DojoRepo dojoRepo;
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo createOrUpdateDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	 public Optional<Dojo> findById(Long id) {
	    	return dojoRepo.findById(id);
	    }
	 
	 public void deleteById(Long id) {
		 dojoRepo.deleteById(id);
	 }
}
