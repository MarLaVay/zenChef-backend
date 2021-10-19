package com.maryan.zenchef.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
    private String firstname;
    private String password;
    @OneToMany
    private List<Recipe> recipes;

}
