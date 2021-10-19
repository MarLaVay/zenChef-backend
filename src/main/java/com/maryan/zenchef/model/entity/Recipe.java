package com.maryan.zenchef.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
public class Recipe implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Chef chef;

    private String title;
    private String method;
    
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<Quantity> quantities;

}
