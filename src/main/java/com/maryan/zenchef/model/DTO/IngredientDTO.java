package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO implements Serializable {
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
