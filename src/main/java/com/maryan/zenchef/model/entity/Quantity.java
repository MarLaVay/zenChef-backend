package com.maryan.zenchef.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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
    @JsonBackReference
    private Recipe recipe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Ingredient ingredient;
}
