package com.brianLester.exam2.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.exam2.models.Messages;

public interface MessageRepo extends CrudRepository<Messages,Long>{
	
	public List <Messages> findAll();

}
