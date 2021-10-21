package com.maryan.zenchef.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quantity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private int number;
    private String type;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Recipe recipe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;
}
