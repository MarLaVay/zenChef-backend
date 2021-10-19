package com.maryan.zenchef.controller;

import com.maryan.zenchef.model.DTO.CreateRecipeDTO;
import com.maryan.zenchef.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	RecipeRepository recipeRepository;

	@PostMapping
	public ResponseEntity<Void> createRecipe(@RequestBody CreateRecipeDTO recipeDTO) {

		recipeRepository.save(recipeDTO.toEntity());
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
