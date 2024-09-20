/**
 * 
 */
package com.spring.api.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.inventory.model.User;

/**
 * 
 */
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
