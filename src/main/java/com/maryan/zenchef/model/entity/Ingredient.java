package com.maryan.zenchef.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient implements Serializable {
	
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }
}
