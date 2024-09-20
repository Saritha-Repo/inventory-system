/**
 * 
 */
package com.spring.api.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="user_login")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;
		
		@Column(nullable = false)
	    private String name;
		
		@Column(nullable = false,unique = true)
	    private String email;
		
		@Column(nullable = false)
	    private String password;
}
