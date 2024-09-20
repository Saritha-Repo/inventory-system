/**
 * 
 */
package com.spring.api.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.inventory.model.Payment;

/**
 * 
 */
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
