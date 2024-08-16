package com.mnasro.patient.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mnasro.patient.dto.UpdatePatientDTO;

@Component
public class UpdatePatientDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UpdatePatientDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdatePatientDTO dto = (UpdatePatientDTO) target;

		if(StringUtils.isBlank(dto.getName()))
		{
			errors.rejectValue("name", "Invalid name", "Invalid name");
		}
		
		if(dto.getAge()<=0)
		{
			errors.rejectValue("age", "Invalid age", "Invalid age");
		}
	}

}