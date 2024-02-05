package com.klix.financing.domain.bankapplication.integration.solidbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

	@JsonProperty("offer")
	private OfferResponse offer;

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public OfferResponse getOffer() {
		return offer;
	}
     
}
