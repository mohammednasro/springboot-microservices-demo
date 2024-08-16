package com.mnasro.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mnasro.payment.dto.AddPaymentDTO;
import com.mnasro.payment.dto.PageDTO;
import com.mnasro.payment.dto.PaymentDTO;
import com.mnasro.payment.exception.WebserviceValidationException;
import com.mnasro.payment.facade.PaymentFacade;
import com.mnasro.payment.util.ValidationUtils;
import com.mnasro.payment.validator.AddPaymentDTOValidator;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/payment")
@Tag(name = "Payments")
public class PaymentController {

	@Autowired
	@Qualifier("paymentFacade")
	private PaymentFacade paymentFacade;

	@Autowired
	private AddPaymentDTOValidator addPaymentDTOValidator;

	
    @GetMapping("/{id}")
	public PaymentDTO getById(@PathVariable long id) {
		return paymentFacade.get(id);
	}
    
    @GetMapping("/transaction/{tranId}")
    public PaymentDTO getPaymentByTranId(@PathVariable String tranId){
        return paymentFacade.getByTranId(tranId);
    }
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PaymentDTO add(@RequestBody @Valid AddPaymentDTO addPaymentDTO) {
		
		Errors errors = ValidationUtils.validateObject(addPaymentDTOValidator, addPaymentDTO);

		if (errors.hasErrors()) {
			throw new WebserviceValidationException(errors);
		}

		return paymentFacade.add(addPaymentDTO);
	}
	
    @GetMapping
  	public PageDTO<PaymentDTO> getPatientPayments(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "timestamp") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = true) long patientId) {

    	Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

  		return paymentFacade.getPatientPayments(patientId,pageable);
  	}

}
