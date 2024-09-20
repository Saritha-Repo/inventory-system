/**
 * 
 */
package com.spring.api.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String paymentId;
	private String status;
	private Double amount;
	
	public Payment(String paymentId, String status, Double amount) {
		this.paymentId = paymentId;
		this.status = status;
		this.amount = amount;
	}
}
