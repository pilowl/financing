package com.klix.financing.domain.application.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetApplicationResponse {
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;
    
    @JsonProperty("monthlyIncomeAmount")
    private double monthlyIncomeAmount;

    @JsonProperty("amount")
    private double amount;

    // FastBank-specific fields
    @JsonProperty("monthlyCreditLiabilities")
    private double monthlyCreditLiabilities;

    @JsonProperty("dependents")
    private int dependents;

    @JsonProperty("agreeToDataSharing")
    private boolean agreeToDataSharing;

    // SolidBank-specific fields
    @JsonProperty("monthlyExpenses")
    private float monthlyExpenses;

    @JsonProperty("maritalStatus")
    private MaritalStatus maritalStatus;

    @JsonProperty("agreeToBeScored")
    private boolean agreeToBeScored; 

    @JsonProperty("offers")
    private List<OfferResponse> offers;
}
