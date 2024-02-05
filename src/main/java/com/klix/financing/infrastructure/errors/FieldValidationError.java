package com.klix.financing.infrastructure.errors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldValidationError {
    @JsonProperty("message")
    private String message;

    @JsonProperty("errors")
    private Map<String, String> fieldErrors;

    public static FieldValidationError fromObjectErrors(String message, List<ObjectError> errors) {
        FieldValidationError error = new FieldValidationError();
        error.message = message;
        error.fieldErrors = new HashMap<String, String>();
        errors.forEach(err -> {
            error.fieldErrors.put(((FieldError) err).getField(), err.getDefaultMessage());
        });
        return error;
    }
}
