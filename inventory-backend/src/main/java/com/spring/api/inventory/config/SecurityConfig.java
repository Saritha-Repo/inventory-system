/**
 * 
 */
package com.spring.api.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 */
@Configuration
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors()  // Enable CORS support
	            .and()
	            .csrf().disable()  // Disable CSRF for simplicity, be careful in production
	            .authorizeRequests()
	            .requestMatchers("/api/auth/login", "/api/auth/register").permitAll()  // Allow login and register without authentication
	            .anyRequest().authenticated();  // Other requests require authentication

	        return http.build();
	    }
}
