package com.maryan.zenchef.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter @Setter
public class Quantity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private int number;
    private String type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;
}
