/**
 * 
 */
package com.spring.api.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.inventory.model.Inventory;
import com.spring.api.inventory.model.CustomerOrder;
import com.spring.api.inventory.repository.OrderRepository;

/**
 * 
 */
@Service
public class OrderService {
	
	OrderRepository orderRepository;
	InventoryService inventoryService;
	
	@Autowired
	public OrderService(OrderRepository orderRespository,InventoryService inventoryService) {
		this.orderRepository = orderRespository;
		this.inventoryService = inventoryService;
	}

	public CustomerOrder createOrder(String orderId,Long ItemId, int quantity) {
		if(!inventoryService.checkInventory(ItemId, quantity)) {
			throw new RuntimeException("Not Enough Inventory");
		}
		
		Inventory inventory = inventoryService.getById(ItemId);
		
		inventoryService.reduceInventory(ItemId, quantity);
		
		CustomerOrder order = new CustomerOrder(orderId, "CREATED", inventory);
		
		return orderRepository.save(order);
	}
	
	public CustomerOrder updateOrderStatus(Long orderId, String status) {
		CustomerOrder order = orderRepository.findById(orderId).orElseThrow();
		order.setStatus(status);
		
		return orderRepository.save(order);
	}
}
