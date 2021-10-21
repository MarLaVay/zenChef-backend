package com.maryan.zenchef.model.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
	
	private long id;
	@NotBlank(message = "{mandatory.name}")
    private String userName;
	@NotBlank(message = "{mandatory.email}")
    private String email;
    private String bio;
    private String displayName;
    private String photoURL;
    private List<String> shortcuts = new ArrayList<>();
    private boolean active;
    private Date creation_date;
}