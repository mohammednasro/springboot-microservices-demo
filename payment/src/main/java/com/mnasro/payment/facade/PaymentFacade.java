package com.mnasro.payment.facade;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mnasro.payment.dto.AddPaymentDTO;
import com.mnasro.payment.dto.PageDTO;
import com.mnasro.payment.dto.PaymentDTO;
 
public interface PaymentFacade {

    public PaymentDTO get(Long id);

    public PaymentDTO getByTranId(String tranId);

    public PaymentDTO add(AddPaymentDTO dto);

    public List<PaymentDTO> getPatientPayments(Long patientId);
    
    public PageDTO<PaymentDTO>  getPatientPayments(Long patientId,Pageable pageable);

}
