/**
 * 
 */
package com.spring.api.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.inventory.model.CustomerOrder;

/**
 * 
 */
public interface OrderRepository extends JpaRepository<CustomerOrder, Long>{

}
