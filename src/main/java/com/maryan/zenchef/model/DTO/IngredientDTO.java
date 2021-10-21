package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientDTO {
    private String name;

    public Ingredient toEntity() {
        return new Ingredient(name);
    }
}
