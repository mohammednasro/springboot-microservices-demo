package com.mnasro.payment.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mnasro.payment.dto.AddPaymentDTO;
import com.mnasro.payment.dto.PageDTO;
import com.mnasro.payment.dto.PaymentDTO;
import com.mnasro.payment.facade.PaymentFacade;
import com.mnasro.payment.mapper.PaymentMapper;
import com.mnasro.payment.model.PaymentModel;
import com.mnasro.payment.service.PaymentService;

@Service(value = "paymentFacade")
public class DefaultPaymentFacade implements PaymentFacade {
 
	@Autowired
	@Qualifier("paymentService")
	private PaymentService paymentService;
	
	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public PaymentDTO get(Long id) {		
		return paymentMapper.toDTO( paymentService.get(id));
	}
	
	@Override
	public PaymentDTO getByTranId(String tranId) {
		return paymentMapper.toDTO(paymentService.getByTranId(tranId));
	}

	@Override
	public PaymentDTO add(AddPaymentDTO dto) {
        return paymentMapper.toDTO(paymentService.add(dto.getAmount(), dto.getPatientId()));
	}

	@Override
	public List<PaymentDTO> getPatientPayments(Long patientId) {
	     return paymentMapper.toDTOs(paymentService.getPatientPayments(patientId));
	}

	@Override
	public PageDTO<PaymentDTO> getPatientPayments(Long patientId, Pageable pageable) {
		Page<PaymentModel> all = paymentService.getPatientPayments(patientId, pageable);
		
		List<PaymentDTO> list=new ArrayList<>();
		if(!all.isEmpty())
		{
			list.addAll(paymentMapper.toDTOs(all.toList()));
		}
		
		return new PageDTO<PaymentDTO>(list,all.getNumber(),all.getSize(),all.getTotalElements(),all.getTotalPages());

	}

	

}
