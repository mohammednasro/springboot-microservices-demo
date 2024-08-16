package com.mnasro.patient.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnasro.patient.model.PatientModel;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {

	public Page<PatientModel> findAll(Pageable pageable);
}