package com.mnasro.doctor.model.dto;

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
public class AddPatientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "please enter valid Name")
	private String name;
	@NotNull(message = "please enter valid age")
	private Integer age;
}
