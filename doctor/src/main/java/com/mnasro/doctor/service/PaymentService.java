package com.mnasro.doctor.service;

import com.mnasro.doctor.model.dto.AddPaymentDTO;
import com.mnasro.doctor.model.dto.PaymentDTO;

public interface PaymentService {

	public PaymentDTO add(AddPaymentDTO addPaymentDTO);

	public PaymentDTO getByTranId(String tranId);
}
