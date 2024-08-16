package com.mnasro.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mnasro.doctor.model.dto.AddPaymentDTO;
import com.mnasro.doctor.model.dto.PaymentDTO;
import com.mnasro.doctor.proxy.PaymentProxy;
import com.mnasro.doctor.service.PaymentService;

@Service(value = "paymentService")
public class DefaultPaymentService implements PaymentService {
	private static final String ADD_PAYMENT_DTO_BE_NULL = "addPaymentDTO cannot be null!";

    @Autowired
    private PaymentProxy paymentProxy;

	@Override
	public PaymentDTO add(AddPaymentDTO addPaymentDTO) {
		Preconditions.checkNotNull(addPaymentDTO, ADD_PAYMENT_DTO_BE_NULL);
        return this.paymentProxy.addPayment(addPaymentDTO);
	}

	@Override
	public PaymentDTO getByTranId(String tranId) {
        return this.paymentProxy.getPaymentByTranId(tranId);
	}
}