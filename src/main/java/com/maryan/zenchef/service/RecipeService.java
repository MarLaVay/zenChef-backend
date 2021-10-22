package com.maryan.zenchef.service;

import com.maryan.zenchef.model.DTO.CreateRecipeDTO;
import com.maryan.zenchef.model.DTO.QuantityDTO;
import com.maryan.zenchef.model.DTO.RecipeDTO;
import com.maryan.zenchef.model.entity.Quantity;
import com.maryan.zenchef.model.entity.Recipe;
import com.maryan.zenchef.repository.ChefRepository;
import com.maryan.zenchef.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

public class RecipeService {

    ChefRepository chefRepository;
    IngredientRepository ingredientRepository;


    public RecipeService(ChefRepository chefRepository,
                         IngredientRepository ingredientRepository) {
        this.chefRepository = chefRepository;
        this.ingredientRepository = ingredientRepository;
    }

    /**
     * Va générer une instance complète d'un Recipe, avec ses relations
     * @return Recipe
     */
    public Recipe toRecipeEntity(CreateRecipeDTO recipeDTO) {

        Recipe newRecipe = new Recipe();
        newRecipe.setTitle(recipeDTO.getTitle());
        newRecipe.setMethod(recipeDTO.getMethod());

        //relie la recette à un chef - TODO le relier au chef de la session
        newRecipe.setChef(chefRepository.findById(1L).orElseThrow());

        //crée les entités des quantités et les relie à la recette
        List<Quantity> quantities = new ArrayList<>();
        recipeDTO.getQuantityDTOS()
                .forEach(quantityDTO ->
                {
                    Quantity newQuantity = new Quantity();
                    newQuantity.setNumber(quantityDTO.getNumber());
                    newQuantity.setMeasuringUnit(quantityDTO.getMeasuringUnit());
                    //relier les ingrédients
                    newQuantity.setIngredient(ingredientRepository.findById(quantityDTO.getIngredientID()).orElseThrow());
                    //Relier à la recette
                    newQuantity.setRecipe(newRecipe);
                    quantities.add(newQuantity);
                }
                );
        newRecipe.setQuantities(quantities);

        return newRecipe;
    }

    public RecipeDTO toRecipeDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setTitle(recipe.getTitle());
        recipeDTO.setMethod(recipe.getMethod());

        //création des DTO des quantités et ingrédients
        List<QuantityDTO> quantityDTOS = new ArrayList<>();
        recipe.getQuantities().forEach(quantity -> {
            QuantityDTO quantityDTO = new QuantityDTO(quantity);
            quantityDTOS.add(quantityDTO);
        });
        recipeDTO.setQuantityDTOList(quantityDTOS);

        return recipeDTO;

    }
}
