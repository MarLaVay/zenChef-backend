package com.maryan.zenchef.controller;

import com.maryan.zenchef.model.DTO.CreateRecipeDTO;
import com.maryan.zenchef.model.DTO.RecipeDTO;
import com.maryan.zenchef.model.entity.Chef;
import com.maryan.zenchef.model.entity.Recipe;
import com.maryan.zenchef.repository.ChefRepository;
import com.maryan.zenchef.repository.RecipeRepository;
import com.maryan.zenchef.security.UserPrincipal;
import com.maryan.zenchef.service.RecipeService;
import com.maryan.zenchef.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/recipe")
public class RecipeController {

	RecipeRepository recipeRepository;
	ChefRepository chefRepository;
	@Autowired RecipeService recipeService;
	@Autowired UserService userService;

	@Autowired
	public RecipeController(RecipeRepository recipeRepository,
							ChefRepository chefRepository) {
		this.recipeRepository = recipeRepository;
		this.chefRepository = chefRepository;
	}



	@GetMapping("/{idRecipe}")
	public ResponseEntity<RecipeDTO> getOneRecipe(@PathVariable("idRecipe") Long id) {

		Recipe recipe = recipeRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("pas de recette"));
		RecipeDTO recipeDTO = recipeService.toRecipeDTO(recipe);

		return ResponseEntity.ok(recipeDTO);
	}

	@PostMapping
	public ResponseEntity<RecipeDTO> createRecipe(@RequestBody CreateRecipeDTO recipeDTO) {

		Recipe newRecipe = recipeService.toRecipeEntity(recipeDTO);

		return ResponseEntity.ok(recipeService.toRecipeDTO(recipeRepository.save(newRecipe)));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateRecipe() {
		//TODO
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{idRecipe}")
	public ResponseEntity<Void> deleteRecipe(@PathVariable("idRecipe") Long idRecipe) {
		//TODO
		Recipe recipeToRemove= recipeRepository.findById(idRecipe)
				.orElseThrow(() -> new RuntimeException("recette non trouvée"));
		recipeRepository.delete(recipeToRemove);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	@GetMapping
	public ResponseEntity<List<RecipeDTO>> getAllRecipes() {

		List<Recipe> recipes = recipeRepository
				.findAllByChef(userService.getAuthenticatedUser());

		List<RecipeDTO> recipeDTOList = recipes
				.stream()
				.map(recipe ->  recipeService.toRecipeDTO(recipe))
				.collect(Collectors.toList());

		return ResponseEntity.ok(recipeDTOList);
	}


}
