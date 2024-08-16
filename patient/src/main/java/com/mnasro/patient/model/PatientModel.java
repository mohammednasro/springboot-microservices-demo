package com.mnasro.patient.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Patient")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "name",nullable = false)
	private String name;
	
	@Column(name= "age",nullable = false)
	private Integer age;
	
	@Column(name= "timestamp",nullable = false)
	private Date timestamp;

}
