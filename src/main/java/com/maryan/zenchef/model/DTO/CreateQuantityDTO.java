package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Quantity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuantityDTO implements Serializable {
    private Long id;
    private float number;
    private String measuringUnit;
    private Long ingredientID;




    /*
    Quantity -> QuantityDTO
     */
    public CreateQuantityDTO(Quantity quantity) {
        this.id = quantity.getId();
        this.number = quantity.getNumber();
        this.measuringUnit = quantity.getMeasuringUnit();
//        this.ingredientDTO = new IngredientDTO(quantity.getIngredient());
    }
}
