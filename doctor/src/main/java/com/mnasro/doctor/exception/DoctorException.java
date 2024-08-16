package com.mnasro.doctor.exception;


public class DoctorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DoctorException(String msg) {
    super(msg);
  }
}