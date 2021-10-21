package com.maryan.zenchef.model.DTO;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserDTO implements Serializable {
	
	private String userName;
	private String displayName;
	private String email;
	private String password;
	private String bio;

}