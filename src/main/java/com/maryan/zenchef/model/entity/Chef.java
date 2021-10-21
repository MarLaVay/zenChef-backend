package com.maryan.zenchef.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Builder 
@AllArgsConstructor
@NoArgsConstructor
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
