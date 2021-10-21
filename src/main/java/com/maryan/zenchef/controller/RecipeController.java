package com.maryan.zenchef.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	@PostMapping
	public ResponseEntity<Void> createRecipe() {
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateRecipe() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteRecipe() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
