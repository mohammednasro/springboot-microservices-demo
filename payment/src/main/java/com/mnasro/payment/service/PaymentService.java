package com.mnasro.payment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mnasro.payment.model.PaymentModel;

public interface PaymentService {
	
	
    public PaymentModel get(Long id);

    public PaymentModel getByTranId(String tranId);

	public PaymentModel add( Double amount,Long patientId );
	
    public List<PaymentModel> getPatientPayments(Long patientId);
    
    public Page<PaymentModel> getPatientPayments(Long patientId,Pageable pageable);

}
