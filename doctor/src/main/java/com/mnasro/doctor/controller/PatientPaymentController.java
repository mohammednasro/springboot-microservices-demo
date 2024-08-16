package com.mnasro.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnasro.doctor.model.dto.AddPaymentDTO;
import com.mnasro.doctor.model.dto.PaymentDTO;
import com.mnasro.doctor.service.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/doctor/payment")
@Tag(name = "Doctor Patient Payment")
public class PatientPaymentController {

	@Autowired
	@Qualifier("paymentService")
	private PaymentService paymentService;

	@CircuitBreaker(name = "getPaymentByTranId")
	@GetMapping("/transaction/{tranId}")
	public PaymentDTO getPaymentByTranId(@PathVariable String tranId) {
		return paymentService.getByTranId(tranId);
	}

	@CircuitBreaker(name = "addPayment")
	@PostMapping
	public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto) {
		return paymentService.add(dto);
	}

}
