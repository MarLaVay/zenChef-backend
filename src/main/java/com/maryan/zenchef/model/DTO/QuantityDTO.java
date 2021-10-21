package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Quantity;
import com.maryan.zenchef.repository.IngredientRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityDTO {
    private int number;
    private String measuringUnit;
    private Long ingredientID;

    IngredientRepository ingredientRepository;

    public Quantity toEntity() {
        Quantity newQuantity = new Quantity();
        newQuantity.setNumber(this.number);
        newQuantity.setIngredient(ingredientRepository.findById(ingredientID).orElseThrow());
    return newQuantity;
    }
}
