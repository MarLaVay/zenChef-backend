package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Quantity;
import com.maryan.zenchef.model.entity.Recipe;
import com.maryan.zenchef.repository.ChefRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class CreateRecipeDTO {
    private String title;
    private String method;
    private List<QuantityDTO> quantityDTOS;

    ChefRepository chefRepository;

    public Recipe toEntity() {

        Recipe recipe = new Recipe();

        recipe.setMethod(this.method);
        recipe.setTitle(this.title);

        //va relier les quantités aux ingrédients en BDD
        List<Quantity> quantities = this.quantityDTOS
                .stream()
                .map(QuantityDTO::toEntity)
                .collect(Collectors.toList());

        //ajoute la référence de la recette
        quantities.forEach(quantity -> quantity.setRecipe(recipe));

        return recipe;
    }
}
