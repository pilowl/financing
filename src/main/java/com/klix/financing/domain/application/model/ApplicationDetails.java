package com.klix.financing.domain.application.model;

import java.util.UUID;

public class ApplicationDetails {
    private UUID uuid; 
    private String phoneNumber;
    private String email;
    private double monthlyIncomeAmount;
    private double amount;
    private double monthlyCreditLiabilities;
    private int dependents;
    private boolean agreeToDataSharing;
    private double monthlyExpenses;
    private MaritalStatus maritalStatus;
    private boolean agreeToBeScored;

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
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
    public void setMonthlyIncomeAmount(float monthlyIncomeAmount) {
        this.monthlyIncomeAmount = monthlyIncomeAmount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public double getMonthlyCreditLiabilities() {
        return monthlyCreditLiabilities;
    }
    public void setMonthlyCreditLiabilities(float monthlyCreditLiabilities) {
        this.monthlyCreditLiabilities = monthlyCreditLiabilities;
    }
    public int getDependents() {
        return dependents;
    }
    public void setDependents(int dependants) {
        this.dependents = dependants;
    }
    public boolean isAgreeToDataSharing() {
        return agreeToDataSharing;
    }
    public void setAgreeToDataSharing(boolean agreeToDataSharing) {
        this.agreeToDataSharing = agreeToDataSharing;
    }
    public double getMonthlyExpenses() {
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
}
