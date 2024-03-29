package com.klix.financing.domain.bankapplication.integration.solidbank.dto;

import java.util.Date;

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
    private Date firstRepaymentDate;

    public Double getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    public Double getTotalRepaymentAmount() {
        return totalRepaymentAmount;
    }

    public Integer getNumberOfPayments() {
        return numberOfPayments;
    }

    public Date getFirstRepaymentDate() {
        return firstRepaymentDate;
    }

    public void setMonthlyPaymentAmount(Double monthlyPaymentAmount) {
        this.monthlyPaymentAmount = monthlyPaymentAmount;
    }

    public void setTotalRepaymentAmount(Double totalRepaymentAmount) {
        this.totalRepaymentAmount = totalRepaymentAmount;
    }

    public void setNumberOfPayments(Integer numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public void setFirstRepaymentDate(Date firstRepaymentDate) {
        this.firstRepaymentDate = firstRepaymentDate;
    }
}
