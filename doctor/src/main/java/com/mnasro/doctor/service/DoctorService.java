package com.mnasro.doctor.service;

import com.mnasro.doctor.model.dto.AddPatientDTO;
import com.mnasro.doctor.model.dto.PatientDTO;

public interface DoctorService {
	
	public PatientDTO addPatient(AddPatientDTO addPatientDTO);

    public PatientDTO findPatientById(long id);
    
}
