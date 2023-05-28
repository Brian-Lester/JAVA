package com.brianLester.exam2.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.exam2.models.House;

public interface HouseRepo extends CrudRepository <House, Long>{
	
	List <House> findAll();
}
