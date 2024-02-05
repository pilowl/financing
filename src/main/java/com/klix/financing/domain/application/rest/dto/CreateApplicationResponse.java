package com.klix.financing.domain.application.rest.dto;

import java.util.UUID;

public class CreateApplicationResponse {
    private UUID id;

    public CreateApplicationResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}