package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Recipe;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDTO {
    private Long id;
    private String title;
    private String method;
    private List<QuantityDTO> quantityDTOList = new ArrayList<>();

    public RecipeDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.method = recipe.getMethod();
        recipe.getQuantities().forEach(quantity -> {
            QuantityDTO quantityDTO = new QuantityDTO(quantity);
            this.quantityDTOList.add(quantityDTO);});
    }
}
