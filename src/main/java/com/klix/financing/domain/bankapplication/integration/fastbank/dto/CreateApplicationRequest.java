package com.klix.financing.domain.bankapplication.integration.fastbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateApplicationRequest {

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("monthlyIncomeAmount")
    private Double monthlyIncomeAmount;

    @JsonProperty("monthlyCreditLiabilities")
    private Double monthlyCreditLiabilities;

    @JsonProperty("dependents")
    private Integer dependents;

    @JsonProperty("agreeToDataSharing")
    private Boolean agreeToDataSharing;

    @JsonProperty("amount")
    private Double amount;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMonthlyIncomeAmount() {
        return monthlyIncomeAmount;
    }

    public void setMonthlyIncomeAmount(Double monthlyIncomeAmount) {
        this.monthlyIncomeAmount = monthlyIncomeAmount;
    }

    public Double getMonthlyCreditLiabilities() {
        return monthlyCreditLiabilities;
    }

    public void setMonthlyCreditLiabilities(Double monthlyCreditLiabilities) {
        this.monthlyCreditLiabilities = monthlyCreditLiabilities;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependants) {
        this.dependents = dependants;
    }

    public Boolean getAgreeToDataSharing() {
        return agreeToDataSharing;
    }

    public void setAgreeToDataSharing(Boolean agreeToDataSharing) {
        this.agreeToDataSharing = agreeToDataSharing;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CreateApplicationRequest [phoneNumber=" + phoneNumber + ", email=" + email + ", monthlyIncomeAmount="
                + monthlyIncomeAmount + ", monthlyCreditLiabilities=" + monthlyCreditLiabilities + ", dependants="
                + dependents + ", agreeToDataSharing=" + agreeToDataSharing + ", amount=" + amount + "]";
    }

}
