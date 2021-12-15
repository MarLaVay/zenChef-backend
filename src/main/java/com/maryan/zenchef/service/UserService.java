package com.maryan.zenchef.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.maryan.zenchef.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maryan.zenchef.errors.exception.AlreadyExistsException;
import com.maryan.zenchef.model.DTO.CreateUserDTO;
import com.maryan.zenchef.model.DTO.UserDTO;
import com.maryan.zenchef.model.entity.Chef;
import com.maryan.zenchef.repository.ChefRepository;
import com.maryan.zenchef.security.JwtTokenProvider;
import com.maryan.zenchef.security.payload.LoginRequest;

@Service
@Transactional
public class UserService{

	@Autowired
    AuthenticationManager authenticationManager;
	
    @Autowired
    ChefRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider tokenProvider;

    /**
     * Get authenticated user
     * @return User
     */
    public Chef getAuthenticatedUser() {
    	
    	final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserPrincipal customUser = (UserPrincipal) authentication.getPrincipal();
//        Long customUserID = customUser.getId();

    	return userRepository.findByName(authentication.getName())
			.orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
//    	return userRepository.findByName(authentication.getName())
//			.orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    }

    /**
     * Register user's account
     * @param username
     * @param email
     * @param password
     * @return User
     */
    public Chef register(CreateUserDTO createUserDTO) {
    	
	   	 if(userRepository.existsByName(createUserDTO.getUserName())) {
	   		 throw new AlreadyExistsException("Nom d'utilisateur déjà pris");
	     }
	
	     if(userRepository.existsByEmail(createUserDTO.getEmail())) {
	    	 throw new AlreadyExistsException("Email déjà pris");
	     }

         // Creating user's account
         final Chef user = Chef.builder()
        		 .name(createUserDTO.getUserName())
        		 .email(createUserDTO.getEmail())
        		 .password(passwordEncoder.encode(createUserDTO.getPassword()))
        		 .build();

         return userRepository.save(user);
    }

    /**
     * Login user
     * @param loginRequest
     * @return String
     */
    public String login(LoginRequest loginRequest) {
    	
    	 Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         loginRequest.getUsernameOrEmail(),
                         loginRequest.getPassword()
                 )
         );

         SecurityContextHolder.getContext().setAuthentication(authentication);

         return tokenProvider.generateToken(authentication);
    }

    /**
     * Get user
     * @param userId
     * @return User
     */
    public Chef get(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    }

    /**
     * Update user account
     * @param userDTO
     */
    public void updateUser(UserDTO userDTO) {

    	final Chef user = userRepository.findById(userDTO.getId())
    			.orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    	
    	user.setName(userDTO.getUserName());
    	user.setEmail(userDTO.getEmail());
    	
    	userRepository.saveAndFlush(user);
    }

    /**
     * Enable or disable user
     * @param userId
     * @param active
     */
    public void enableDisableUser(long userId, boolean active) {

    	final Chef user = userRepository.findById(userId)
    			.orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    	
    	userRepository.saveAndFlush(user);
    }

    /**
     * Get user by username or email
     * @param username
     * @param email
     * @return User
     */
    public Chef getUserByUsernameOrEmail(String username, String email) {
    	
    	return userRepository.findByNameOrEmail(username, email)
				.orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    }
  
}
