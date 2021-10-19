package com.maryan.zenchef.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter
public class Ingredient implements Serializable {
	
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
