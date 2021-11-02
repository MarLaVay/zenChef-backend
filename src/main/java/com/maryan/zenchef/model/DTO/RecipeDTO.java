package com.maryan.zenchef.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO implements Serializable {
    private Long id;
    private String title;
    private String method;
    private List<QuantityDTO> quantityDTOList = new ArrayList<>();

}
