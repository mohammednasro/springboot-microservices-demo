package com.mnasro.patient.facade;

import org.springframework.data.domain.Pageable;

import com.mnasro.patient.dto.AddPatientDTO;
import com.mnasro.patient.dto.PageDTO;
import com.mnasro.patient.dto.PatientDTO;
import com.mnasro.patient.dto.PaymentDTO;
import com.mnasro.patient.dto.UpdatePatientDTO;


public interface PatientFacade {

	public PatientDTO add(AddPatientDTO addPatientDTO);

	public PatientDTO update(UpdatePatientDTO updatePatientDTO);

    public PageDTO<PatientDTO> findAll(Pageable pageable);

    public PatientDTO findById(long id);
    
	public void delete(long id);

	public PageDTO<PaymentDTO> getPatientPayments(long patientId,int page,int size,String sortBy,String direction) ;


}
