package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientDTO {
    private Long id;
    private String name;

    // Ingredient -> IngredientDTO
    public IngredientDTO(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
    }

    public Ingredient toEntity() {
        return new Ingredient(null, name);
    }
}
