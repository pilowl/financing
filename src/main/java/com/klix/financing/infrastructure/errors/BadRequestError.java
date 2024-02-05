package com.klix.financing.infrastructure.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BadRequestError {

    @JsonProperty("message")
    private String message;

    public BadRequestError(String message) {
        this.message = message;
    }

}
