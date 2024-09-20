/**
 * 
 */
package com.spring.api.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.inventory.model.Inventory;
import com.spring.api.inventory.repository.InventoryRepository;

/**
 * 
 */
@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryService(InventoryRepository repository) {
		this.inventoryRepository = repository;
	}
	
	public List<Inventory> getAllItems(){
		return inventoryRepository.findAll();
	}
	
	public Inventory getById(Long itemId) {
		return inventoryRepository.findById(itemId).orElseThrow();
	}
	
	public boolean checkInventory(Long itemId,int quantity) {
		Inventory inventory = inventoryRepository.findById(itemId).orElseThrow();
		return inventory.getQuantity() >= quantity;
	}
	
	public void reduceInventory(Long itemId, int quantity) {
		Inventory inventory = inventoryRepository.findById(itemId).orElseThrow();
		inventory.setQuantity(inventory.getQuantity() - quantity);
		inventoryRepository.save(inventory);
	}
	
	public Inventory addInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
}
