package com.maryan.zenchef.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maryan.zenchef.model.DTO.AuthUserDTO;
import com.maryan.zenchef.model.DTO.CreateUserDTO;
import com.maryan.zenchef.model.entity.Chef;
import com.maryan.zenchef.security.JwtTokenProvider;
import com.maryan.zenchef.security.payload.ApiResponse;
import com.maryan.zenchef.security.payload.LoginRequest;
import com.maryan.zenchef.service.UserService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping( value = "/signin", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestParam String usernameOrEmail, @RequestParam String password) {

    	final String token = userService.login(new LoginRequest(usernameOrEmail, password));
    	
    	final Chef user = userService.getAuthenticatedUser();
    	
        return ResponseEntity.ok(new AuthUserDTO(user, token));
    }

    @PostMapping( value = "/signup")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody CreateUserDTO user) {
    	
         final Chef userCreated = userService.register(user);

         final URI location = ServletUriComponentsBuilder
                 .fromCurrentContextPath().path("/api/users/{username}")
                 .buildAndExpand(userCreated.getName()).toUri();
         
         return ResponseEntity.created(location).body(new ApiResponse(true, "Utilisateur enregistré avec succès"));
    }
    
    @GetMapping( value =  "/access-token")
    public ResponseEntity<?> isValidToken(@RequestParam String accessToken){
    	
    	if(tokenProvider.validateToken(accessToken)) {
    		
    		final Chef user = userService.getAuthenticatedUser();
    		
    		return ResponseEntity.ok(new AuthUserDTO(user, accessToken));
    	}
    	
    	return ResponseEntity.badRequest().build();
    	
    }
}
