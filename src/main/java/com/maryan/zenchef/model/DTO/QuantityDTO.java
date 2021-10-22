package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Quantity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityDTO {
    private Long id;
    private int number;
    private String measuringUnit;
    private Long ingredientID;




    /*
    Quantity -> QuantityDTO
     */
    public QuantityDTO(Quantity quantity) {
        this.id = quantity.getId();
        this.number = quantity.getNumber();
        this.measuringUnit = quantity.getMeasuringUnit();
//        this.ingredientDTO = new IngredientDTO(quantity.getIngredient());
    }
}
