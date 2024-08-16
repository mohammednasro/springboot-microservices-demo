package com.mnasro.patient.mapper;

import org.mapstruct.Mapper;

import com.mnasro.patient.dto.AddPatientDTO;
import com.mnasro.patient.dto.PatientDTO;
import com.mnasro.patient.dto.UpdatePatientDTO;
import com.mnasro.patient.model.PatientModel;

@Mapper(componentModel = "spring")
public interface PatientMapper {


	public PatientModel toEntity(PatientDTO dto);
	
	public PatientModel toEntity(AddPatientDTO dto);
	
	public PatientDTO toDTO(PatientModel entity);
	
	public PatientModel toEntity(UpdatePatientDTO dto);

	
 
}
