package com.mnasro.payment.mapper;
import java.util.List;

import org.mapstruct.Mapper;

import com.mnasro.payment.dto.PaymentDTO;
import com.mnasro.payment.model.PaymentModel;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

	public PaymentModel toEntity(PaymentDTO dto);
	public PaymentDTO toDTO(PaymentModel entity);
    List<PaymentDTO> toDTOs(List<PaymentModel> entities);
    List<PaymentModel> toEntities(List<PaymentDTO> dtos);
}
