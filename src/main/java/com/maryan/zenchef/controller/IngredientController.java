package com.maryan.zenchef.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	@PostMapping
	public ResponseEntity<Void> createIngredient() {
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateIngredient() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteIngredient() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
