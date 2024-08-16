package com.mnasro.patient.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mnasro.patient.dto.PageDTO;
import com.mnasro.patient.dto.PaymentDTO;

@FeignClient(name = "PAYMENT-SERVICE" )
public interface PaymentProxy {
    @GetMapping("/v1/payment")
  	public PageDTO<PaymentDTO> getPatientPayments(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "timestamp") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = true) long patientId) ;
}
