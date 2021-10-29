package com.maryan.zenchef.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quantity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private float number;
    private String measuringUnit;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Recipe recipe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;
}
