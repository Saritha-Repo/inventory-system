/**
 * 
 */
package com.spring.api.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.inventory.model.Inventory;

/**
 * 
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	

}
