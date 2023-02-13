package com.brianLester.login_reg.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.brianLester.login_reg.models.User;

public interface UserRepo extends CrudRepository<User, Long> {

	List<User> findAll();
	
    Optional<User> findByEmail(String email);
		

}

