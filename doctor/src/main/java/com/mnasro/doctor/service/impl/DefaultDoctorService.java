package com.mnasro.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnasro.doctor.model.dto.AddPatientDTO;
import com.mnasro.doctor.model.dto.PatientDTO;
import com.mnasro.doctor.proxy.PatientProxy;
import com.mnasro.doctor.service.DoctorService;

@Service(value = "patientService")
public class DefaultDoctorService implements DoctorService {

    @Autowired
    private PatientProxy patientProxy;
    
	@Override
	public PatientDTO addPatient(AddPatientDTO addPatientDTO) {
		return patientProxy.add(addPatientDTO);
	}

	@Override
	public PatientDTO findPatientById(long id) {
		return patientProxy.getById(id);
	}

}
