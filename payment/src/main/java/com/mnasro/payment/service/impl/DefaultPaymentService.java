package com.mnasro.payment.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mnasro.payment.exception.PaymentException;
import com.mnasro.payment.model.PaymentModel;
import com.mnasro.payment.repository.PaymentRepository;
import com.mnasro.payment.service.PatientService;
import com.mnasro.payment.service.PaymentService;

@Service(value = "paymentService")
public class DefaultPaymentService implements PaymentService {

	private static final String TRANID_CANNOT_BE_NULL = "tranId cannot be null or empty!";
	private static final String ID_CANNOT_BE_NULL = "id cannot be null or empty!";
	private static final String AMOUNT_CANNOT_BE_NULL = "amount cannot be null or less than or equal to zero!";
	private static final String PATIENT_ID_CANNOT_BE_NULL = "patientId cannot be null or less than or equal to zero!";

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	@Qualifier("patientService")
	private PatientService patientService;
	
	@Override
	public PaymentModel getByTranId(String tranId) {

		Preconditions.checkNotNull(tranId, TRANID_CANNOT_BE_NULL);

		Optional<PaymentModel> payment = paymentRepository.findByTranId(tranId);
		if (payment.isEmpty()) {
			throw new PaymentException("payment for tranId not found");
		}

		return payment.get();
	}

	@Override
	public PaymentModel add(Double amount, Long patientId) {
		
		Preconditions.checkArgument(amount!=null && amount>0, AMOUNT_CANNOT_BE_NULL);
		Preconditions.checkNotNull(patientId!=null && patientId>0, PATIENT_ID_CANNOT_BE_NULL);

		if(!patientService.isExistById(patientId)) {
			throw new PaymentException("Patient id dose not exist!");
		}
		
		PaymentModel paymentModel = PaymentModel.builder()
												.amount(amount)
												.patientId(patientId)
												.tranId(UUID.randomUUID().toString())
												.timestamp(new Date())
												.build();
		
		return paymentRepository.save(paymentModel);
	}

	@Override
	public List<PaymentModel> getPatientPayments(Long patientId) {
		return paymentRepository.findAllByPatientId(patientId);
	}

	@Override
	public Page<PaymentModel> getPatientPayments(Long patientId, Pageable pageable) {
		pageable =pageable!=null? pageable:PageRequest.of(0, 10, Sort.by("timestamp").ascending());
		return paymentRepository.findAllByPatientId(patientId, pageable);
		
	}

	@Override
	public PaymentModel get(Long id) {
		Preconditions.checkNotNull(id, ID_CANNOT_BE_NULL);
		 
		Optional<PaymentModel> byId = paymentRepository.findById(id);
		
		if(byId.isEmpty())
		{
			throw new PaymentException("payment id not found");
		}
		
		return byId.get();
	}

}
