package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Recipe;

public class CreateRecipeDTO {


    public Recipe toEntity() {
        return new Recipe();
    }
}
