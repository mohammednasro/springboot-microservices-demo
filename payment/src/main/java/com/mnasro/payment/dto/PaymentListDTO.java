package com.mnasro.payment.dto;

import java.io.Serializable;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentListDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "the list is empty!")
	private Set<PaymentDTO> list;

}
