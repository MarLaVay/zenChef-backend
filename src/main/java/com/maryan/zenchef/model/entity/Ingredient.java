package com.maryan.zenchef.model.entity;

<<<<<<< Updated upstream
import lombok.Getter;
import lombok.Setter;
=======
import lombok.*;
>>>>>>> Stashed changes

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
<<<<<<< Updated upstream
@Getter @Setter
=======
@Data
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> Stashed changes
public class Ingredient implements Serializable {
	
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
