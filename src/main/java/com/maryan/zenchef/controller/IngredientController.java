package com.maryan.zenchef.controller;

import com.maryan.zenchef.model.DTO.IngredientDTO;
import com.maryan.zenchef.model.entity.Ingredient;
import com.maryan.zenchef.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	IngredientRepository ingredientRepository;

	@Autowired
	public IngredientController(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	@PostMapping
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
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteIngredient(@RequestBody Long ingredientID) {
		Ingredient ingredientToDelete = ingredientRepository
				.findById(ingredientID)
				.orElseThrow(
						() -> new RuntimeException("cet ingrédient n'existe pas en BDD"));
		ingredientRepository.delete(ingredientToDelete);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
