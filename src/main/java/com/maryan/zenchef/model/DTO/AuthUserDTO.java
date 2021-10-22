package com.maryan.zenchef.model.DTO;

import java.io.Serializable;

import org.springframework.security.core.userdetails.User;

import com.maryan.zenchef.model.entity.Chef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class AuthUserDTO implements Serializable {

    private String accessToken;
    
	public AuthUserDTO(Chef user, String accessToken) {
		this.accessToken = accessToken;
	}
}
