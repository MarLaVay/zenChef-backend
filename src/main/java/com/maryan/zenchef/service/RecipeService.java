package com.maryan.zenchef.service;

import com.maryan.zenchef.model.DTO.CreateRecipeDTO;
import com.maryan.zenchef.model.DTO.QuantityDTO;
import com.maryan.zenchef.model.DTO.RecipeDTO;
import com.maryan.zenchef.model.entity.Quantity;
import com.maryan.zenchef.model.entity.Recipe;
import com.maryan.zenchef.repository.ChefRepository;
import com.maryan.zenchef.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RecipeService {

    ChefRepository chefRepository;
    IngredientRepository ingredientRepository;
    UserService userService;


    public RecipeService(ChefRepository chefRepository,
                         IngredientRepository ingredientRepository,
                         UserService userService) {
        this.chefRepository = chefRepository;
        this.ingredientRepository = ingredientRepository;
        this.userService = userService;
    }

    /**
     * Va générer une instance complète d'un Recipe, avec ses relations
     * @return Recipe
     */
    public Recipe toRecipeEntity(CreateRecipeDTO recipeDTO) {

        Recipe newRecipe = new Recipe();
        newRecipe.setTitle(recipeDTO.getTitle());
        newRecipe.setMethod(recipeDTO.getMethod());

        //relie la recette à un chef
        newRecipe.setChef(userService.getAuthenticatedUser());

        //crée les entités des quantités et les relie à la recette
        List<Quantity> quantities = new ArrayList<>();
        recipeDTO.getQuantityDTOList()
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
