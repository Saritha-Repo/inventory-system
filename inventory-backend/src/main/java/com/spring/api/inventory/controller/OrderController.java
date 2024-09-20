/**
 * 
 */
package com.spring.api.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.inventory.model.CustomerOrder;
import com.spring.api.inventory.service.OrderService;

/**
 * 
 */
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public CustomerOrder createOrder(@RequestParam String orderId,@RequestParam Long itemId, @RequestParam int quantity) {
		return orderService.createOrder(orderId, itemId, quantity);
	}

	@PutMapping("/{orderId}")
	public CustomerOrder updateOrderStatus(@RequestParam Long orderId,@RequestParam String status) {
		return orderService.updateOrderStatus(orderId, status);
	}
}
