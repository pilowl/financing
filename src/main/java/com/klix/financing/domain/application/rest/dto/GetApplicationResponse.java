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

    public double getMonthlyIncomeAmount() {
        return monthlyIncomeAmount;
    }

    public void setMonthlyIncomeAmount(double monthlyIncomeAmount) {
        this.monthlyIncomeAmount = monthlyIncomeAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMonthlyCreditLiabilities() {
        return monthlyCreditLiabilities;
    }

    public void setMonthlyCreditLiabilities(double monthlyCreditLiabilities) {
        this.monthlyCreditLiabilities = monthlyCreditLiabilities;
    }

    public int getDependents() {
        return dependents;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public boolean isAgreeToDataSharing() {
        return agreeToDataSharing;
    }

    public void setAgreeToDataSharing(boolean agreeToDataSharing) {
        this.agreeToDataSharing = agreeToDataSharing;
    }

    public float getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(float monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isAgreeToBeScored() {
        return agreeToBeScored;
    }

    public void setAgreeToBeScored(boolean agreeToBeScored) {
        this.agreeToBeScored = agreeToBeScored;
    }

    public List<OfferResponse> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferResponse> offers) {
        this.offers = offers;
    }
}
