package com.maryan.zenchef.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
public class Recipe implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String method;
    @OneToMany
    private List<Quantity> quantities;




}
