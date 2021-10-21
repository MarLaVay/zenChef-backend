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
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
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
