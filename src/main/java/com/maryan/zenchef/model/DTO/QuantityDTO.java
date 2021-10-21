package com.maryan.zenchef.model.DTO;

import com.maryan.zenchef.model.entity.Quantity;
import com.maryan.zenchef.repository.IngredientRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityDTO {
    private Long id;
    private int number;
    private String measuringUnit;
    private IngredientDTO ingredientDTO;

    IngredientRepository ingredientRepository;

    public Quantity toEntity() {
        Quantity newQuantity = new Quantity();
        newQuantity.setNumber(this.number);
        newQuantity.setIngredient(ingredientRepository.findById(ingredientDTO.getId()).orElseThrow());
    return newQuantity;
    }

    /*
    Quantity -> QuantityDTO
     */
    public QuantityDTO(Quantity quantity) {
        this.id = quantity.getId();
        this.number = quantity.getNumber();
        this.measuringUnit = quantity.getType();
        this.ingredientDTO = new IngredientDTO(quantity.getIngredient());
    }
}
