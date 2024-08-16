package com.mnasro.payment.service;

import com.mnasro.payment.dto.PatientDTO;

public interface PatientService {
	
	public PatientDTO getById(long id);
	
	public boolean isExistById(long id);
	
}
