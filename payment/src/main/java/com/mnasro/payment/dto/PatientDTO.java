package com.mnasro.payment.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "please enter valid Name")
	private String name;
	@NotNull(message = "please enter valid age")
	private Integer age;
	@NotNull
	@DateTimeFormat
	@Past(message = "please enter valid timestamp")
	private Date timestamp;
	
}
