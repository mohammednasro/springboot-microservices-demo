package com.mnasro.patient.util;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.BindException;

public class ValidationUtils {

    public static Errors validateObject(Validator validator, Object object) {
        BindException errors = new BindException(object, "object");
        validator.validate(object, errors);
        return errors;
    }
}