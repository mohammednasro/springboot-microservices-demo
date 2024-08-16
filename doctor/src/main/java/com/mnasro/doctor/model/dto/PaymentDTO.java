package com.mnasro.doctor.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long id;
    private String tranId;
    private Double amount;
    private Long patientId;
	private Date timestamp;

	
}
