package com.mnasro.payment.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mnasro.payment.dto.PatientDTO;

@FeignClient(name = "PATIENT-SERVICE",path = "patient")
public interface PatientProxy {
	
    @GetMapping("/v1/patient/{id}")
	public PatientDTO getById(@PathVariable long id);

}