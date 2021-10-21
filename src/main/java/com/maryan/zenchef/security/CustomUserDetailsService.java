package com.maryan.zenchef.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maryan.zenchef.model.entity.Chef;
import com.maryan.zenchef.repository.ChefRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	  	@Autowired
	    ChefRepository chefRepository;

	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String usernameOrEmail)
	            throws UsernameNotFoundException {
	        // Let people login with either username or email
	        Chef user = chefRepository.findByNameOrEmail(usernameOrEmail, usernameOrEmail)
	                .orElseThrow(() -> 
	                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
	        );

	        return UserPrincipal.create(user);
	    }

	    // This method is used by JWTAuthenticationFilter
	    @Transactional
	    public UserDetails loadUserById(Long id) {
	        Chef user = chefRepository.findById(id).orElseThrow(
	            () -> new UsernameNotFoundException("User not found with id : " + id)
	        );

	        return UserPrincipal.create(user);
	    }
}
