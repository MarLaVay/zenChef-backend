package com.maryan.zenchef.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecipeDTO implements Serializable {
    private String title;
    private String method;
    private List<CreateQuantityDTO> quantityDTOList;


//    public Recipe toEntity() {
//
//        Recipe recipe = new Recipe();
//
//        recipe.setMethod(this.method);
//        recipe.setTitle(this.title);
//
//        //va relier les quantités aux ingrédients en BDD
//        List<Quantity> quantities = this.quantityDTOS
//                .stream()
//                .map(QuantityDTO::toEntity)
//                .collect(Collectors.toList());
//
//        //ajoute la référence de la recette
//        quantities.forEach(quantity -> quantity.setRecipe(recipe));
//
//        return recipe;
//    }
}
