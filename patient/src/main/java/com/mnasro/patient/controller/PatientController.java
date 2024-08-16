package com.mnasro.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mnasro.patient.dto.AddPatientDTO;
import com.mnasro.patient.dto.PageDTO;
import com.mnasro.patient.dto.PatientDTO;
import com.mnasro.patient.dto.PaymentDTO;
import com.mnasro.patient.dto.UpdatePatientDTO;
import com.mnasro.patient.exception.WebserviceValidationException;
import com.mnasro.patient.facade.PatientFacade;
import com.mnasro.patient.util.ValidationUtils;
import com.mnasro.patient.validator.AddPatientDTOValidator;
import com.mnasro.patient.validator.UpdatePatientDTOValidator;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/patient")
@Tag(name = "Patient")
public class PatientController {

	@Autowired
	@Qualifier("patientFacade")
	private PatientFacade patientFacade;

	@Autowired
	private AddPatientDTOValidator addPatientDTOValidator;

	@Autowired
	private UpdatePatientDTOValidator updatePatientDTOValidator;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PatientDTO add(@RequestBody @Valid AddPatientDTO patientDTO) {
		
		Errors errors = ValidationUtils.validateObject(addPatientDTOValidator, patientDTO);

		if (errors.hasErrors()) {
			throw new WebserviceValidationException(errors);
		}

		return patientFacade.add(patientDTO);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PatientDTO update(@PathVariable long id , @RequestBody @Valid UpdatePatientDTO updatePatientDTO) {
		updatePatientDTO.setId(id);
		Errors errors = ValidationUtils.validateObject(updatePatientDTOValidator, updatePatientDTO);

		if (errors.hasErrors()) {
			throw new WebserviceValidationException(errors);
		}

		return patientFacade.update(updatePatientDTO);
	}
	
    @GetMapping("/{id}")
	public PatientDTO getById(@PathVariable long id) {

		return patientFacade.findById(id);
	}
    
    @DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		patientFacade.delete(id);
	}
    
    @GetMapping
  	public PageDTO<PatientDTO> getAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "age") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

    	Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

  		return patientFacade.findAll(pageable);
  	}
    
    @GetMapping("/payments")
  	public PageDTO<PaymentDTO> getPatientPayments(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "patientId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = true) long patientId) {

  		return patientFacade.getPatientPayments(patientId, page, size, sortBy, direction);
  	}

    
	
}
