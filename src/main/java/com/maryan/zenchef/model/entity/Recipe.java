package com.maryan.zenchef.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Chef chef;

    private String title;
    private String method;
    
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    @JsonManagedReference
    private List<Quantity> quantities = new ArrayList<>();

}
