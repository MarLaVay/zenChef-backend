package com.maryan.zenchef.controller;

import com.maryan.zenchef.model.DTO.CreateRecipeDTO;
import com.maryan.zenchef.model.entity.Recipe;
import com.maryan.zenchef.repository.ChefRepository;
import com.maryan.zenchef.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/recipe")
public class RecipeController {

	RecipeRepository recipeRepository;
	ChefRepository chefRepository;

	@Autowired
	public RecipeController(RecipeRepository recipeRepository, ChefRepository chefRepository) {
		this.recipeRepository = recipeRepository;
		this.chefRepository = chefRepository;
	}



	@GetMapping("/{idRecipe}")
	public ResponseEntity<Recipe> getOneRecipe(@PathVariable("idRecipe") Long id) {

		return ResponseEntity.ok(recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("pas de recette")));
	}

	@PostMapping
	public ResponseEntity<Recipe> createRecipe(@RequestBody CreateRecipeDTO recipeDTO) {

		Recipe newRecipe = recipeDTO.toEntity();
		//relie la recette à un chef - TODO
		newRecipe.setChef(chefRepository.findById(1L).orElseThrow());

		return ResponseEntity.ok(recipeRepository.save(newRecipe));
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
