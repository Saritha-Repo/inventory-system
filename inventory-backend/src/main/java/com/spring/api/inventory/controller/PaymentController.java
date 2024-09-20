/**
 * 
 */
package com.spring.api.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.inventory.model.Payment;
import com.spring.api.inventory.service.PaymentService;

/**
 * 
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

	private PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping
	public Payment processPayment(@RequestParam String paymentId, @RequestParam Double amount) {
		return paymentService.processPayment(paymentId, amount);
	}
}
