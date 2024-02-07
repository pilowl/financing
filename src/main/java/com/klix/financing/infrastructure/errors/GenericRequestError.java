package com.klix.financing.infrastructure.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericRequestError {

    @JsonProperty("message")
    private String message;

    public GenericRequestError(String message) {
        this.message = message;
    }

}
