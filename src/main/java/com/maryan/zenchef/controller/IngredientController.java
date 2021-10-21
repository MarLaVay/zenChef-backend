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
<<<<<<< Updated upstream
	public ResponseEntity<Void> createIngredient() {
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateIngredient() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
=======
	public ResponseEntity<Ingredient> createIngredient(@RequestBody IngredientDTO ingredientDTO) {

		return ResponseEntity.ok(ingredientRepository.save(ingredientDTO.toEntity()));
	}
	
	@PutMapping
	public ResponseEntity<Ingredient> updateIngredient(@RequestBody IngredientDTO ingredientDTO) {

		Ingredient ingredientToUpdate = ingredientRepository
				.findById(ingredientDTO.getId())
				.orElseThrow(
						() -> new RuntimeException("cet ingrédient n'existe pas en BDD"));
		ingredientToUpdate.setName(ingredientDTO.getName());

		return ResponseEntity.ok(ingredientRepository.save(ingredientToUpdate));
>>>>>>> Stashed changes
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteIngredient(@RequestBody Long ingredientID) {
		Ingredient ingredientToDelete = ingredientRepository
				.findById(ingredientID)
				.orElseThrow(
						() -> new RuntimeException("cet ingrédient n'existe pas en BDD"));
		ingredientRepository.delete(ingredientToDelete);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
