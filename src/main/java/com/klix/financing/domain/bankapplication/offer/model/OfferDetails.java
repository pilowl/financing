package com.klix.financing.domain.bankapplication.offer.model;

import java.util.Date;

public class OfferDetails {
    
    private Double monthlyPaymentAmount;

    private Double totalRepaymentAmount;

    private Integer numberOfPayments;

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
