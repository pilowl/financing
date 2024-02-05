package com.klix.financing.domain.bankapplication.integration.solidbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateApplicationRequest {
    @JsonProperty("phone")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("monthlyIncome")
    private Double monthlyIncome;

    @JsonProperty("monthlyExpenses")
    private Double monthlyExpenses;

    @JsonProperty("maritalStatus")
    private MaritalStatus maritalStatus;

    @JsonProperty("agreeToBeScored")
    private Boolean agreeToBeScored;

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

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(Double monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getAgreeToBeScored() {
        return agreeToBeScored;
    }

    public void setAgreeToBeScored(Boolean agreeToBeScored) {
        this.agreeToBeScored = agreeToBeScored;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "CreateApplicationRequest [phoneNumber=" + phoneNumber + ", email=" + email + ", monthlyIncome="
				+ monthlyIncome + ", monthlyExpenses=" + monthlyExpenses + ", maritalStatus=" + maritalStatus
				+ ", agreeToBeScored=" + agreeToBeScored + ", amount=" + amount + "]";
	}
}
