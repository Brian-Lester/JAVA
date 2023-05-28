package com.brianLester.exam2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brianLester.exam2.models.Messages;
import com.brianLester.exam2.repos.MessageRepo;

@Service
public class MessageService {
	
	@Autowired
	MessageRepo repo;
	
	public Messages create(Messages newMessage, BindingResult result) {
	      
	      if (result.hasErrors()) {
	    	  return null;
	      }
	      
	      
	      return repo.save(newMessage);
	 }

}
