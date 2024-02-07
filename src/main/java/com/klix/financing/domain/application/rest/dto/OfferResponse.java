package com.klix.financing.domain.application.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferResponse {

    @JsonProperty("bankName")
    private String bankName;

    @JsonProperty("firstRepayment")
    private Date firstRepayment;

    @JsonProperty("monthlyPayment")
    private Double monthlyPayment;

    @JsonProperty("paymentAmount")
    private Integer paymentAmount;

    @JsonProperty("totalRepayment")
    private Double totalRepayment;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setFirstRepayment(Date firstRepayment) {
        this.firstRepayment = firstRepayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setTotalRepayment(Double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

}
