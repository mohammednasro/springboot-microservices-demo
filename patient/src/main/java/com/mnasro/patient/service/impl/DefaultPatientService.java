package com.mnasro.patient.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.mnasro.patient.exception.PatientException;
import com.mnasro.patient.model.PatientModel;
import com.mnasro.patient.repository.PatientRepository;
import com.mnasro.patient.service.PatientService;

@Service(value = "patientService")
public class DefaultPatientService implements PatientService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultPatientService.class);

	private static final String PATIENT_MODEL_BE_NULL = "PatientModel cannot be null!";
	private static final String PATIENT_MODEL_ID_BE_NULL = "Id cannot be null!";

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public PatientModel add(PatientModel patientModel) {
		Preconditions.checkNotNull(patientModel, PATIENT_MODEL_BE_NULL);
		patientModel.setId(null);
		patientModel.setTimestamp(new Date());
		LOG.info("start add Patient: name [{}] , age [{}] , timestamp [{}] ",
				patientModel.getName(), patientModel.getAge(), patientModel.getTimestamp());
		PatientModel saved = patientRepository.save(patientModel);
		LOG.info(
				"The Patient has been created successfully :id[{}], name [{}] , age [{}] , timestamp [{}]",
				saved.getId(), saved.getName(), saved.getAge(), saved.getTimestamp());
		
		return saved;
	}

	@Transactional(noRollbackFor = {
			PatientException.class }, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addAll(Set<PatientModel> set) {
		for (PatientModel entity : set) {
			patientRepository.save(entity);
		}
	}

	@Override
	public Page<PatientModel> findAll(Pageable pageable) {
		
		
		pageable =pageable!=null? pageable:PageRequest.of(0, 10, Sort.by("age").ascending());

		return patientRepository.findAll(pageable);
	}

	@Override
	public PatientModel findById(long id) {
		Preconditions.checkNotNull(id, PATIENT_MODEL_ID_BE_NULL);
 
		Optional<PatientModel> byId = patientRepository.findById(id);
		 
		if(byId.isEmpty())
		{
			throw new PatientException("Patient for id not found");
		}
		
		return byId.get();
	}

	@Override
	public PatientModel update(PatientModel patientModel) {
		Preconditions.checkNotNull(patientModel, PATIENT_MODEL_BE_NULL);
		Preconditions.checkNotNull(patientModel.getId(), PATIENT_MODEL_ID_BE_NULL);

		PatientModel byId = findById(patientModel.getId());
		patientModel.setTimestamp(byId.getTimestamp());

		LOG.info("start add Patient: name [{}] , age [{}] , timestamp [{}] ",
				patientModel.getName(), patientModel.getAge(), patientModel.getTimestamp());
		PatientModel saved = patientRepository.save(patientModel);
		LOG.info(
				"The Patient has been created successfully :id[{}], name [{}] , age [{}] , timestamp [{}]",
				saved.getId(), saved.getName(), saved.getAge(), saved.getTimestamp());
		
		
		return saved;
	}

	@Override
	public void deleteById(long id) {
		Preconditions.checkNotNull(id, PATIENT_MODEL_ID_BE_NULL);
		 
		Optional<PatientModel> byId = patientRepository.findById(id);
		
		if(byId.isEmpty())
		{
			throw new PatientException("Patient for id not found");
		}
		patientRepository.delete(byId.get());
	}

}