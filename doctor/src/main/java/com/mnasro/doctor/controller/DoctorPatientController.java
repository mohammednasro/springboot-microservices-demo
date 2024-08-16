package com.mnasro.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mnasro.doctor.exception.DoctorException;
import com.mnasro.doctor.model.dto.AddPatientDTO;
import com.mnasro.doctor.model.dto.PatientDTO;
import com.mnasro.doctor.service.DoctorService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/doctor/patient")
@Tag(name = "Doctor Patient")
public class DoctorPatientController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PatientDTO add(@RequestBody @Valid AddPatientDTO addPatientDTO) {
		return doctorService.addPatient(addPatientDTO);
	}
	
//	@CircuitBreaker(name = "getById" , fallbackMethod = "getFallbackMethod")
	@CircuitBreaker(name = "getById")
    @GetMapping("/{id}")
	public PatientDTO getById(@PathVariable long id) {
		return doctorService.findPatientById(id);
	}
    
    public void getFallbackMethod(Exception e){
    	throw new DoctorException(e.getMessage());
    }
   
}
