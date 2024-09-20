/**
 * 
 */
package com.spring.api.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String orderId;
	private String status;
	
	@OneToOne
	private Inventory inventory;
	
	public CustomerOrder(String orderId, String status,Inventory inventory) {
		this.orderId = orderId;
		this.status = status;
		this.inventory = inventory;
	}
}
