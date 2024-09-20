/**
 * 
 */
package com.spring.api.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.api.inventory.model.User;
import com.spring.api.inventory.repository.UserRepository;

/**
 * 
 */
@Service
public class UserService {
	
	
	public UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepositroy) {
		this.userRepository = userRepositroy;
	}

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	 public void registerUser(User user) throws Exception {
	        // Check if the email is already registered
	        if (userRepository.findByEmail(user.getEmail()) != null) {
	            throw new Exception("Email is already registered");
	        }
	        // Save the user to the PostgreSQL database
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        
	        userRepository.save(user);
	        System.out.println("User registered: " + user.getName() + ", " + user.getEmail());
	    }
	 
	 public User login(String email, String password) throws Exception {
	        // Find the user by email
	        User user = userRepository.findByEmail(email);
	        if (user == null) {
	            throw new Exception("User not found with the provided email.");
	        }

	        // Compare the passwords (bcrypt if encrypted)
	        if (!passwordEncoder.matches(password, user.getPassword())) {
	            throw new Exception("Invalid credentials. Please try again.");
	        }

	        // Return the user if credentials are valid
	        return user;
	    }
}
