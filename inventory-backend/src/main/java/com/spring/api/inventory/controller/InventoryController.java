/**
 * 
 */
package com.spring.api.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.inventory.model.Inventory;
import com.spring.api.inventory.service.InventoryService;

/**
 * 
 */
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

	private InventoryService inventoryService;
	
	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@PostMapping
	public Inventory addItem(@RequestBody Inventory inventory) {
		return inventoryService.addInventory(inventory);
	}
	
	@GetMapping
	public List<Inventory> getAllItems(){
		return inventoryService.getAllItems();
	}
	
	@GetMapping("/check/{itemId}/{quantity}")
	public boolean checkInventory(@PathVariable Long itemId, @PathVariable int quantity) {
		return inventoryService.checkInventory(itemId, quantity);
	}
}
