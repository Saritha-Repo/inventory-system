/**
 * 
 */
package com.spring.api.inventory.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.inventory.model.User;
import com.spring.api.inventory.service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	public UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	 @PostMapping("/login")
	    public @ResponseBody ResponseEntity<?> login(@RequestBody User user) {
	        try {
	            // Call the login method in AuthService
	            User loggedInUser = userService.login(user.getEmail(), user.getPassword());

	            // If login successful, return the user's information (excluding password)
	            Map<String,String> response = new HashMap<String,String>();
	            response.put("message", "Welcome" + loggedInUser.getName());
	            return ResponseEntity.ok(response);

	        } catch (Exception e) {
	            // Return a bad request status with the error message if login fails
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 
	@PostMapping("/register")
	public @ResponseBody ResponseEntity<?> registerUser(@RequestBody User user){
		
		try {
			userService.registerUser(user);
			Map <String,String> response = new HashMap<String, String>();
			response.put("message", "User Registered Successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Error Occured during registartion " + e.getMessage());
		}
	}
}
