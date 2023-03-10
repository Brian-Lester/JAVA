package com.brianLester.dojosNinjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.dojosNinjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {
	
	List<Dojo> findAll();

}
