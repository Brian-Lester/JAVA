package com.brianLester.dojosNinjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.dojosNinjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	
	List<Ninja> findAll();
}
