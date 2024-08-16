package com.mnasro.doctor.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mnasro.doctor.model.dto.AddPaymentDTO;
import com.mnasro.doctor.model.dto.PaymentDTO;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentProxy {

	@GetMapping("/v1/payment/transaction/{tranId}")
	public PaymentDTO getPaymentByTranId(@PathVariable String tranId);

	@PostMapping("/v1/payment")
	public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto);

}