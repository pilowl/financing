package com.klix.financing.domain.application.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreateApplicationRequest {
    
    @JsonProperty("phoneNumber")
    @NotNull
    @Pattern(regexp = "\\+371[0-9]{8}")
    private String phoneNumber;

    @JsonProperty("email")
    @NotNull
    @Email
    private String email;
    
    @JsonProperty("monthlyIncomeAmount")
    @NotNull
    @Positive
    private double monthlyIncomeAmount;

    @JsonProperty("amount")
    @NotNull
    @Positive
    private double amount;

    // FastBank-specific fields
    @JsonProperty("monthlyCreditLiabilities")
    @NotNull
    @Positive
    private double monthlyCreditLiabilities;

    @JsonProperty("dependents")
    @NotNull
    @Positive
    private int dependents;

    @JsonProperty("agreeToDataSharing")
    @NotNull
    private boolean agreeToDataSharing;

    // SolidBank-specific fields
    @JsonProperty("monthlyExpenses")
    @NotNull
    @Positive
    private float monthlyExpenses;

    @JsonProperty("maritalStatus")
    @NotNull
    private MaritalStatus maritalStatus;

    @JsonProperty("agreeToBeScored")
    @NotNull
    private boolean agreeToBeScored;

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public double getMonthlyIncomeAmount() {
        return monthlyIncomeAmount;
    }
    public double getAmount() {
        return amount;
    }
    public double getMonthlyCreditLiabilities() {
        return monthlyCreditLiabilities;
    }
    public int getDependents() {
        return dependents;
    }
    public boolean isAgreeToDataSharing() {
        return agreeToDataSharing;
    }
    public double getMonthlyExpenses() {
        return monthlyExpenses;
    }
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }
    public boolean isAgreeToBeScored() {
        return agreeToBeScored;
    }
}
