package com.mnasro.patient.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mnasro.patient.dto.AddPatientDTO;
import com.mnasro.patient.dto.PageDTO;
import com.mnasro.patient.dto.PatientDTO;
import com.mnasro.patient.dto.PaymentDTO;
import com.mnasro.patient.dto.UpdatePatientDTO;
import com.mnasro.patient.facade.PatientFacade;
import com.mnasro.patient.mapper.PatientMapper;
import com.mnasro.patient.model.PatientModel;
import com.mnasro.patient.proxy.PaymentProxy;
import com.mnasro.patient.service.PatientService;


@Service(value = "patientFacade")
public class DefaultPatientFacade implements PatientFacade {

	private static final String ADD_PATIENT_DTO_BE_NULL = "addPatientDTO cannot be null!";

	private static final String UPDATE_PATIENT_DTO_BE_NULL = "updatePatientDTO cannot be null!";

	private static final String PATIENT_DTO_ID_BE_NULL = "Id cannot be null!";

	@Autowired
	@Qualifier("patientService")
	private PatientService patientService;

	@Autowired
	private PaymentProxy paymentProxy;
	
	@Autowired
	private PatientMapper patientMapper;

	@Override
	public PatientDTO add(AddPatientDTO addPatientDTO) {
		Preconditions.checkNotNull(addPatientDTO, ADD_PATIENT_DTO_BE_NULL);

		return patientMapper.toDTO(patientService.add(patientMapper.toEntity(addPatientDTO)));
	}

	@Override
	public PageDTO<PatientDTO> findAll(Pageable pageable) {
		Page<PatientModel> all = patientService.findAll(pageable);
		
		
		List<PatientDTO> list=new ArrayList<>();
		for (PatientModel model : all.toList()) {
			list.add(patientMapper.toDTO(model));
		}
		
		return new PageDTO<PatientDTO>(list,all.getNumber(),all.getSize(),all.getTotalElements(),all.getTotalPages());
	}

	@Override
	public PatientDTO findById(long id) {
		Preconditions.checkNotNull(id, PATIENT_DTO_ID_BE_NULL);
		
		return patientMapper.toDTO( patientService.findById(id));
	}

	@Override
	public PatientDTO update(UpdatePatientDTO updatePatientDTO) {
		Preconditions.checkNotNull(updatePatientDTO, UPDATE_PATIENT_DTO_BE_NULL);

		return patientMapper.toDTO(patientService.update(patientMapper.toEntity(updatePatientDTO)));
	}

	@Override
	public void delete(long id) {
		patientService.deleteById(id);
	}

	@Override
	public PageDTO<PaymentDTO> getPatientPayments(long patientId, int page, int size, String sortBy, String direction) {
		return paymentProxy.getPatientPayments(page, size, sortBy, direction, patientId);
	}
}
