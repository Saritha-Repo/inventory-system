/**
 * 
 */
package com.spring.api.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.inventory.model.Payment;
import com.spring.api.inventory.repository.PaymentRepository;

/**
 * 
 */
@Service
public class PaymentService {
	
	private PaymentRepository paymentRespository;
	
	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRespository = paymentRepository;
	}
	
	public Payment processPayment(String paymentId, Double amount) {
		
		Payment payment = new Payment(paymentId, "SUCCESS", amount);
		
		return paymentRespository.save(payment);
	}

}
