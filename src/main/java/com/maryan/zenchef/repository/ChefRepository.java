package com.maryan.zenchef.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maryan.zenchef.model.entity.Chef;

public interface ChefRepository extends JpaRepository<Chef, Long> {

	Optional<Chef> findByNameOrEmail(String nameOrEmail, String usernameOrEmail);
	
	Optional<Chef> findByName(String name);
	
	boolean existsByName(String username);
	
	boolean existsByEmail(String email);
}
