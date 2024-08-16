package com.mnasro.patient.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "please enter valid Name")
	private String name;
	
	@NotNull(message = "please enter valid age")
	private Integer age;

}
