package com.mnasro.payment.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mnasro.payment.dto.AddPaymentDTO;
import com.mnasro.payment.service.PatientService;

@Component
public class AddPaymentDTOValidator implements Validator {

	@Autowired
	@Qualifier("patientService")
	private PatientService patientService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AddPaymentDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddPaymentDTO dto = (AddPaymentDTO) target;

		if(dto.getAmount()<=0)
		{
			errors.rejectValue("amount", "Invalid amount", "Invalid amount");
		}
		
		validatePatientId(dto.getPatientId(),errors);


	}

	private void validatePatientId(Long patientId, Errors errors) {
		if(patientId==null ||patientId <=0)
		{
			errors.rejectValue("patientId", "Invalid patientId", "Invalid patientId");
			return;
		}	
		
		if(!patientService.isExistById(patientId))
		{
			errors.rejectValue("patientId", "patientId dose not exist", "patientId dose not exist");
			return;
		}
	}

}