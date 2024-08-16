package com.mnasro.patient.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mnasro.patient.model.PatientModel;


public interface PatientService {	
	
	public PatientModel add(PatientModel patientModel);
   
	public PatientModel update(PatientModel patientModel);

    public void addAll(Set<PatientModel> list);

    public Page<PatientModel> findAll(Pageable pageable);
    
    public PatientModel findById(long id);
    
	public void deleteById(long id);


}
