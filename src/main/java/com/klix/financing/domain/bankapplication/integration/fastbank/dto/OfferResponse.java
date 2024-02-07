package com.klix.financing.domain.bankapplication.integration.fastbank.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferResponse {
    
    @JsonProperty("monthlyPaymentAmount")
    private Double monthlyPaymentAmount;

    @JsonProperty("totalRepaymentAmount")
    private Double totalRepaymentAmount;

    @JsonProperty("numberOfPayments")
    private Integer numberOfPayments;

    @JsonProperty("firstRepaymentDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate firstRepaymentDate;

    public Double getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    public Double getTotalRepaymentAmount() {
        return totalRepaymentAmount;
    }

    public Integer getNumberOfPayments() {
        return numberOfPayments;
    }

    public LocalDate getFirstRepaymentDate() {
        return firstRepaymentDate;
    }
}
