package com.maryan.zenchef.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chef implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
    private String firstname;
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "chef")
    private List<Recipe> recipes = new ArrayList<>();

}
