package com.mnasro.payment.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnasro.payment.model.PaymentModel;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

	public Page<PaymentModel> findAll(Pageable pageable);
	
	public Optional<PaymentModel> findByTranId(String tranId);
    
	public Page<PaymentModel> findAllByPatientId(Long patientId,Pageable pageable);
	
	public List<PaymentModel> findAllByPatientId(Long patientId);

}