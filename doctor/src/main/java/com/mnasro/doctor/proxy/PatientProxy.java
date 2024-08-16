package com.mnasro.doctor.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mnasro.doctor.model.dto.AddPatientDTO;
import com.mnasro.doctor.model.dto.PatientDTO;

import jakarta.validation.Valid;

@FeignClient(name = "PATIENT-SERVICE" ,path = "patient")
public interface PatientProxy {

	@PostMapping("/v1/patient")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PatientDTO add(@RequestBody @Valid AddPatientDTO addPatientDTO);
	
    @GetMapping("/v1/patient/{id}")
	public PatientDTO getById(@PathVariable long id);

}